package org.scoula.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.domain.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BookMapperTest {

    @Autowired
    private BookMapper mapper;

    @Test
    void getBookWithDetail() {
        BookVO book = mapper.getBookWithDetail(1);
        log.info(book);
    }

    @Test
    void getBookWithReviews() {
        BookVO book = mapper.getBookWithReviews(1);
        log.info(book);
    }

    @Test
    void getBookWithDetailAndReviews() {
        BookVO book = mapper.getBookWithDetailAndReviews(1);
        log.info(book);
    }
}