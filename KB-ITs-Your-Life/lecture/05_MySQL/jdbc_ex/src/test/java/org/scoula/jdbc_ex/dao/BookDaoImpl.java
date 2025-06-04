package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.domain.BookDetailVO;
import org.scoula.jdbc_ex.domain.BookReviewVO;
import org.scoula.jdbc_ex.domain.BookVO;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDaoImpl implements BookDao {

    Connection conn = JDBCUtil.getConnection();

    // BOOKS 테이블 관련 SQL 명령어

    private static final String BOOK_LIST   = "select * from books ";
    private static final String BOOK_GET    = "select * from books where id = ?";
    private static final String BOOK_INSERT = "insert into books(name, price, ebook) values(?, ?, ?)";
    private static final String BOOK_UPDATE = "update books set name = ?, price = ?, UPDATE_AT = now(), ebook = ? where id = ?";
    private static final String BOOK_DELETE = "delete from books where id = ?";


    private static final String BOOK_INSERT_WITH_DETAIL =
            "INSERT INTO books(name, price, ebook) VALUES (?, ?, ?)";

    private static final String BOOK_DETAIL_INSERT =
            "INSERT INTO book_details(description, book_id) VALUES (?, ?)";

    // Book과 Review를 함께 조회하는 쿼리
    private static final String BOOK_GET_WITH_DETAILS_AND_REVIEWS =
            """
                SELECT b.*, bd.BOOK_DETAILS_ID, bd.DESCRIPTION,
                       r.REVIEW_ID as review_id, r.SCORE
                FROM books b
                LEFT JOIN book_details bd ON b.ID = bd.BOOK_ID
                LEFT JOIN book_reviews r ON b.ID = r.BOOK_ID
                WHERE b.ID = ?
            """;

    private BookVO map(ResultSet rs) throws SQLException {
        return  BookVO.builder()
                .id(rs.getInt("ID"))
                .name(rs.getString("NAME"))
                .price(rs.getInt("PRICE"))
                .regDate(rs.getDate("REG_DATE").toLocalDate())
                .updateAt(rs.getTimestamp("UPDATE_AT").toLocalDateTime())
                .ebook(rs.getBoolean("EBOOK"))
                .build();
    }

    @Override
    public int create(BookVO book) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(BOOK_INSERT)) {
            stmt.setString(1, book.getName());
            stmt.setInt(2, book.getPrice());
            stmt.setBoolean(3, book.getEbook());
            return stmt.executeUpdate();
        }
    }


    @Override
    public List<BookVO> getList() throws SQLException {
        List<BookVO> bookList = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(BOOK_LIST);
             ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
                bookList.add(map(rs));
            }
        }
        return bookList;
    }

    @Override
    public Optional<BookVO> get(Integer id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(BOOK_GET)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public int update(BookVO book) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(BOOK_UPDATE)) {
            stmt.setString(1, book.getName());
            stmt.setInt(2, book.getPrice());
            stmt.setBoolean(3, book.getEbook());
            stmt.setInt(4, book.getId());
            return stmt.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(BOOK_DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }
    }

    @Override
    public int createBookWithDetail(BookVO book, BookDetailVO detail) throws SQLException {
        int result = 0;
        // 트랜잭션 시작 - 자동 커밋 비활성화
        conn.setAutoCommit(false);

        // BOOK_INSERT_WITH_DETAIL = "INSERT INTO books(name, price, ebook) VALUES (?, ?, ?)";
        // (1, '자바' ....)

        // BOOK_DETAIL_INSERT = "INSERT INTO book_details(description, book_id) VALUES (?, ?)";
        // (5,   )


        try (PreparedStatement bookStmt =
                     conn.prepareStatement(BOOK_INSERT_WITH_DETAIL, // 5
                             Statement.RETURN_GENERATED_KEYS)) {

            // 1. Book 등록
            bookStmt.setString(1, book.getName());
            bookStmt.setInt(2, book.getPrice());
            bookStmt.setBoolean(3, book.getEbook());
            result = bookStmt.executeUpdate();

            // 생성된 Book ID 가져오기
            // |GENERATED_KEY|
            // |———————------|
            //|       4     |
            ResultSet generatedKeys = bookStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int bookId = generatedKeys.getInt("GENERATED_KEY"); //5

                // 2. BookDetail 등록
                try (PreparedStatement detailStmt = conn.prepareStatement(BOOK_DETAIL_INSERT)) {
                    detailStmt.setString(1, detail.getDescription());
                    detailStmt.setInt(2, bookId);
                    detailStmt.executeUpdate();
                }
            }

            // 모든 작업이 성공하면 커밋
            conn.commit();
            return result;

        } catch (SQLException e) {
            // 에러 발생시 롤백
            conn.rollback();
            throw e;
        } finally {
            // 자동 커밋 다시 활성화
            conn.setAutoCommit(true);
        }
    }

    // Book 정보와 함께 Detail, Review 정보도 함께 조회
    @Override
    public Optional<BookVO> getBookWithDetailsAndReviews(Integer bookId) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(BOOK_GET_WITH_DETAILS_AND_REVIEWS)) {

            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Book 기본 정보 설정
                BookVO book = BookVO.builder()
                        .id(rs.getInt("ID"))
                        .name(rs.getString("NAME"))
                        .price(rs.getInt("PRICE"))
                        .regDate(rs.getDate("REG_DATE").toLocalDate())
                        .updateAt(rs.getTimestamp("UPDATE_AT").toLocalDateTime())
                        .ebook(rs.getBoolean("EBOOK"))
                        .build();


                BookDetailVO detail = BookDetailVO.builder()
                        .bookDetailsId(rs.getInt("BOOK_DETAILS_ID"))
                        .description(rs.getString("DESCRIPTION"))
                        .bookId(bookId)
                        .build();

                book.setBookDetail(detail);

                // Reviews 설정
                List<BookReviewVO> reviews = new ArrayList<>();

                do {
                    if (rs.getObject("REVIEW_ID") != null) {

                        BookReviewVO review = BookReviewVO.builder()
                                .reviewId(rs.getInt("REVIEW_ID"))
                                .score(rs.getInt("SCORE"))
                                .bookId(bookId)
                                .build();

                        reviews.add(review);
                    }
                } while (rs.next());

                book.setReviews(reviews);
                return Optional.of(book);
            }
            return Optional.empty();
        }
    }
}