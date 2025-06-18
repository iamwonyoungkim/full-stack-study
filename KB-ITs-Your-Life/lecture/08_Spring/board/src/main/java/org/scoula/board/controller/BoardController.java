package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

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
    public String create(BoardDTO board, @RequestParam("files")List<MultipartFile> files) {
        log.info("create" + board);

        // MultipartFile을 DTO에 직접 넣어주기 (자동 주입되지 않음)
        board.setFiles(files);

        service.create(board);

        return "redirect:/board/get?no=" + board.getNo();
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

    @GetMapping("/download/{no}")
    @ResponseBody
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attach = service.getAttachment(no);

        File file = new File(attach.getPath());

        UploadFiles.download(response, file, attach.getFilename());
    }

}
