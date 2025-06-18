package org.scoula.mapper;

import org.scoula.domain.BookVO;
import org.scoula.dto.BookDTO;

import java.util.List;

public interface BookMapper {
    // 모든 책 조회
    List<BookVO> getAllBooks();

    // 책 정보와 상세 정보 조회 (1:1)
    BookVO getBookWithDetail(Integer bookId);

    // 책 정보와 리뷰 목록 조회 (1:다)
    BookVO getBookWithReviews(Integer bookId);

    // 책 정보, 상세 정보, 리뷰 목록 모두 조회 (1:1:다)
    BookVO getBookWithDetailAndReviews(Integer bookId);
}
