package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    final private BoardService service;

    // 목록 요청
    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list", service.getList());
    }

    // 새 글 등록
    @GetMapping("/create")
    public void create() {
        log.info("create");
    }
    @PostMapping("/create")
    public String create(BoardDTO board) {
        log.info("create" + board);

        service.create(board);

        return "redirect:/board/list";
    }

    // 글 상세 보기(조회)
    @GetMapping({"/get", "/update"}) // GET :: /board/get, GET :: /board/update
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get or /update");
        model.addAttribute("board", service.get(no));
    }

    // 글 수정
    @PostMapping("/update")
    public String update(BoardDTO board) {
        log.info("update" + board);

        service.update(board);

        return "redirect:/board/list";
    }

    // 글 삭제
    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no) {
        log.info("delete" + no);

        service.delete(no);

        return "redirect:/board/list";
    }


}
