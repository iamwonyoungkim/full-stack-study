package org.scoula.board.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.common.pagination.PageRequest;

import java.util.List;

public interface BoardMapper {
//    복잡한 쿼리인 경우 @Select()로 구성하는 것은 매우 어려움
//    resources 영역에 쿼리를 xml로 작성하여 Mapper 인터페이스와 연계
//    Mapper 인터페이스의 패키지 경로 동일하게 동일 파일명으로 작성
//    @Select("select * from tbl_board order by no desc")

    int getTotalCount();

    List<BoardVO> getPage(PageRequest pageRequest);

    public List<BoardVO> getList();

    public BoardVO get(Long no);

    public void create(BoardVO board);

    public int update(BoardVO board);

    public int delete(Long no);

    public void createAttachment(BoardAttachmentVO attach);

    public List<BoardAttachmentVO> getAttachmentList(Long bno);

    public BoardAttachmentVO getAttachment(Long no);

    public int deleteAttachment(Long no);

}
