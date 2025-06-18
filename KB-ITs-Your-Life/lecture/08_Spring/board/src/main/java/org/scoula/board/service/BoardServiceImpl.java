package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor // final 멤버를 인자로 가지는 생성자 추가
public class BoardServiceImpl implements BoardService {

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

        // mapper.get(no);의 return값은 BoardVO 타입으로, VO -> DTO 변환이 필요하다.
        BoardDTO board = BoardDTO.of(mapper.get(no));
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new); // null이면 NoSuchElementException 발생
    }

    @Override
    public void create(BoardDTO board) {
        log.info("create......" + board);
        BoardVO vo = board.toVO(); // DTO -> VO 변환
        mapper.create(vo);         // DB insert (insert 후 PK 생성됨)
        board.setNo(vo.getNo());   // PK(no)를 DTO에도 다시 설정
    }

    @Override
    public boolean update(BoardDTO board) {
        log.info("update......" + board);
        return mapper.update(board.toVO()) == 1;
    }

    @Override
    public boolean delete(Long no) {
        log.info("delete......." + no);
        return mapper.delete(no) == 1;
    }

}
