package org.scoula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.domain.BookVO;
import org.scoula.dto.BookDTO;
import org.scoula.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    @Override
    public List<BookDTO> getAllBooks() {
        log.info("getAllBooks 실행");
        return bookMapper.getAllBooks().stream()
                .map(BookDTO::of)
                .toList();
    }

    @Override
    public BookDTO getBookWithDetail(Integer bookId) {
        log.info("getBookWithDetail 실행: bookId = {}", bookId);
        // Optional을 사용하여 null 체크 후 없으면 NoSuchElementException 발생
        return Optional.ofNullable(BookDTO.of(bookMapper.getBookWithDetail(bookId)))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public BookDTO getBookWithReviews(Integer bookId) {
        log.info("getBookWithReviews 실행: bookId = {}", bookId);
        return Optional.ofNullable(BookDTO.of(bookMapper.getBookWithReviews(bookId)))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public BookDTO getBookWithDetailAndReviews(Integer bookId) {
        log.info("getBookWithDetailAndReviews 실행: bookId = {}", bookId);
        return Optional.ofNullable(BookDTO.of(bookMapper.getBookWithDetailAndReviews(bookId)))
                .orElseThrow(NoSuchElementException::new);
    }
}
