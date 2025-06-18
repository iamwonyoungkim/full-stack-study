package org.scoula.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.domain.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j2
class BookMapperTest {
    @Autowired
    private BookMapper mapper;

    @Test
    @DisplayName("책 정보와 상세 정보 조회 테스트")
    void getBookWithDetailTest() {
        BookVO book = mapper.getBookWithDetail(1);
        assertNotNull(book);
        assertNotNull(book.getBookDetail());

        log.info("책 제목: {}", book.getTitle());
        log.info("책 상세 정보: {}", book.getBookDetail());
    }

    @Test
    @DisplayName("책 정보와 리뷰 목록 조회 테스트")
    void getBookWithReviewsTest() {
        BookVO book = mapper.getBookWithReviews(1);
        assertNotNull(book);
        assertNotNull(book.getReviews());

        log.info("책 제목: {}", book.getTitle());
        log.info("리뷰 목록: {}", book.getReviews());
    }

    @Test
    @DisplayName("책 정보, 상세 정보, 리뷰 목록 모두 조회 테스트")
    void getBookWithAllDetailsTest() {
        BookVO book = mapper.getBookWithDetailAndReviews(2);
        assertNotNull(book);
        assertNotNull(book.getBookDetail());
        assertNotNull(book.getReviews());

        log.info("책 제목: {}", book.getTitle());
        log.info("책 상세 정보: {}", book.getBookDetail());
        log.info("리뷰 목록: {}", book.getReviews());
    }
}