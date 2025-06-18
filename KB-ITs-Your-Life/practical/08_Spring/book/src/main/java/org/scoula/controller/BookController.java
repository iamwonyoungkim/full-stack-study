package org.scoula.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
@Log4j2
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/all";
    }

    @GetMapping("/{bookId}/detail") // http://localhost:8080/books/1/detail
    public String getBookWithDetail(@PathVariable Integer bookId, Model model) {
        log.info("getBookWithDetail 호출: bookId = {}", bookId);
        model.addAttribute("book", bookService.getBookWithDetail(bookId));
        return "books/detail";
    }

    @GetMapping("/{bookId}/reviews")
    public String getBookReviews(@PathVariable Integer bookId, Model model) {
        log.info("getBookReviews 호출: bookId = {}", bookId);
        model.addAttribute("book", bookService.getBookWithReviews(bookId));
        return "books/reviews";
    }

    @GetMapping("/{bookId}")
    public String getBookWithDetailAndReviews(@PathVariable Integer bookId, Model model) {
        log.info("getBookWithDetailAndReviews 호출: bookId = {}", bookId);
        model.addAttribute("book", bookService.getBookWithDetailAndReviews(bookId));
        return "books/view";
    }


}
