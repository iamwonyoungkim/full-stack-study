package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.BookDetailVO;
import org.scoula.jdbc_ex.domain.BookReviewVO;
import org.scoula.jdbc_ex.domain.BookVO;

import java.sql.SQLException;
import java.util.List;

class BookDaoImplTest {
    BookDao dao = new BookDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("책과 상세 정보를 함께 등록합니다")
    void createBookWithDetail() throws SQLException {
        // given
        //BookVO book = new BookVO(null, "test", 20, null, null, true, null, null);
        BookVO book = BookVO.builder()
                .name("Test Book")
                .price(25000)
                .ebook(true)
                .build();

        BookDetailVO detail = BookDetailVO.builder()
                .description("자세히")
                .build();

        // when
        int result = dao.createBookWithDetail(book, detail);

        // then
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("책, 상세정보, 리뷰를 함께 조회합니다")
    void getBookWithDetailsAndReviews() throws SQLException {
        // given
        Integer bookId = 1;

        // when
        BookVO book = dao.getBookWithDetailsAndReviews(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // then
        Assertions.assertNotNull(book.getId());
        Assertions.assertNotNull(book.getName());
        Assertions.assertNotNull(book.getBookDetail());
        Assertions.assertNotNull(book.getReviews());

        // BookDetail 검증
        BookDetailVO detail = book.getBookDetail();
        Assertions.assertNotNull(detail.getDescription());
        Assertions.assertEquals(bookId, detail.getBookId());

        // Reviews 검증
        List<BookReviewVO> reviews = book.getReviews();
        reviews.forEach(review -> {
            Assertions.assertNotNull(review.getReviewId());
            Assertions.assertNotNull(review.getScore());
            Assertions.assertEquals(bookId, review.getBookId());
        });

        System.out.println(book);
    }
}