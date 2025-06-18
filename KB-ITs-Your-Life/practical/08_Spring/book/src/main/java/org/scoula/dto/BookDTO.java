package org.scoula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.domain.BookVO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Integer bookId;
    private String title;
    private BookDetailDTO bookDetail;
    private List<ReviewDTO> reviews;

    // VO -> DTO 변환
    public static BookDTO of(BookVO vo) {
        return vo == null ? null : BookDTO.builder()
                .bookId(vo.getBookId())
                .title(vo.getTitle())
                .bookDetail(BookDetailDTO.of(vo.getBookDetail()))
                .reviews(vo.getReviews().stream().map(ReviewDTO::of).toList())
                .build();
    }

    // DTO -> VO 변환
    public BookVO toVO() {
        return BookVO.builder()
                .bookId(bookId)
                .title(title)
                .bookDetail(bookDetail != null ? bookDetail.toVO() : null)
                .reviews(reviews != null ? reviews.stream().map(ReviewDTO::toVO).toList() : null)
                .build();
    }
}
