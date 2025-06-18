package org.scoula.service;

import org.scoula.dto.BookDTO;

import java.util.List;

public interface BookService {
    // 모든 책 조회
    List<BookDTO> getAllBooks();

    // 책 정보와 상세 정보 조회 (1:1)
    BookDTO getBookWithDetail(Integer bookId);

    // 책 정보와 리뷰 목록 조회 (1:다)
    BookDTO getBookWithReviews(Integer bookId);

    // 책 정보, 상세 정보, 리뷰 목록 모두 조회 (1:1:다)
    BookDTO getBookWithDetailAndReviews(Integer bookId);
}
