package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor // final 멤버를 인자로 가지는 생성자 추가
public class BoardServiceImpl implements BoardService {

    private final static String BASE_DIR = "c:/upload/board";

    final private BoardMapper mapper; // 생성자가 1개인 경우 생성자 주입으로 초기화

    @Override
    public List<BoardDTO> getList() {
        log.info("getList..........");
        return mapper.getList().stream() // BoardVO의 스트림
                .map(BoardDTO::of)       // BoardDTO의 스트림
                .toList();               // List<BoardDTO> 변환
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get......" + no);

        BoardVO boardVO = mapper.get(no);
        List<BoardAttachmentVO> attaches = mapper.getAttachmentList(no);

        // mapper.get(no);의 return값은 BoardVO 타입으로, VO -> DTO 변환이 필요하다.
        BoardDTO board = BoardDTO.of(mapper.get(no));

        board.setAttaches(attaches);
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new); // null이면 NoSuchElementException 발생
    }

    // 2개 이상의 insert 문이 실행될 수 있으므로 트랜잭션 처리 필요
    // RuntimeException인 경우만 자동 rollback.
    @Transactional
    @Override
    public BoardDTO create(BoardDTO board) {
        log.info("create......" + board);

        BoardVO boardVO = board.toVO(); // DTO -> VO 변환
        mapper.create(boardVO);         // DB insert (insert 후 PK 생성됨)

        board.setNo(boardVO.getNo());

        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if(files != null && !files.isEmpty()) { // 첨부 파일이 있는 경우
            List<BoardAttachmentVO> attaches = upload(boardVO.getNo(), files);  // ← 리스트 받아옴
            board.setAttaches(attaches);  // ← DTO에 설정
        }

        return get(boardVO.getNo());
    }

    private List<BoardAttachmentVO> upload(Long bno, List<MultipartFile> files) {
        List<BoardAttachmentVO> list = new ArrayList<>();

        for(MultipartFile part: files) {
            if(part.isEmpty()) continue;
            try {
                String uploadPath = UploadFiles.upload(BASE_DIR, part);

                BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
                mapper.createAttachment(attach);

                list.add(attach);

            } catch (IOException e) {
                throw new RuntimeException(e); // @Transactional에서 감지, 자동 rollback
            }
        }

        return list;
    }

    @Override
    public BoardDTO update(BoardDTO board) {
        log.info("update......" + board);
        mapper.update(board.toVO());

        return get(board.getNo());
    }

    @Override
    public BoardDTO delete(Long no) {
        log.info("delete......." + no);
        BoardDTO board = get(no);

        mapper.delete(no);
        return board;
    }

    // 첨부파일 한 개 얻기
    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        return mapper.getAttachment(no);
    }

    // 첨부파일 삭제
    @Override
    public boolean deleteAttachment(Long no) {
        return mapper.deleteAttachment(no) == 1;
    }
}
