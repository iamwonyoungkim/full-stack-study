package org.scoula.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BookServiceTest {

    @Autowired
    private BookService service;

    @Test
    @DisplayName("책 정보, 상세 정보 조회 테스트")
    void getBookWithDetail() {
        BookDTO book = service.getBookWithDetail(1);
        assertNotNull(book);
        assertNotNull(book.getBookDetail());
        log.info("책 전체 정보: {}", book);
    }

    @Test
    @DisplayName("책 정보, 리뷰 목록 조회 테스트")
    void getBookWithReviews() {
        BookDTO book = service.getBookWithReviews(1);
        assertNotNull(book);
        assertNotNull(book.getReviews());
        log.info("책 전체 정보: {}", book);
    }

    @Test
    @DisplayName("책 정보, 상세 정보, 리뷰 목록 모두 조회 테스트")
    void getBookWithDetailAndReviews() {
        BookDTO book = service.getBookWithDetailAndReviews(1);
        assertNotNull(book);
        assertNotNull(book.getBookDetail());
        assertNotNull(book.getReviews());
        log.info("책 전체 정보: {}", book);
    }

    @Test
    @DisplayName("존재하지 않는 책 조회시 예외 발생 테스트")
    void getNotExistBookTest() {
        assertThrows(NoSuchElementException.class, () -> {
            service.getBookWithDetail(999);
        });
    }
}