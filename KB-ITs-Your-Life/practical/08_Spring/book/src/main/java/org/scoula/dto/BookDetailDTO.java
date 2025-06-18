package org.scoula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.domain.BookDetailVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDetailDTO {
    private Integer bookId;
    private String isbn;
    private String publisher;

    // VO -> DTO 변환
    public static BookDetailDTO of(BookDetailVO vo) {
        return vo == null ? null : BookDetailDTO.builder()
                .bookId(vo.getBookId())
                .isbn(vo.getIsbn())
                .publisher(vo.getPublisher())
                .build();
    }

    // DTO -> VO 변환
    public BookDetailVO toVO() {
        return BookDetailVO.builder()
                .bookId(bookId)
                .isbn(isbn)
                .publisher(publisher)
                .build();
    }
}