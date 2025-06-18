package org.scoula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.domain.ReviewVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {
    private Integer reviewId;
    private String content;
    private Integer rating;
    private Integer bookId;

    // VO -> DTO 변환
    public static ReviewDTO of(ReviewVO vo) {
        return vo == null ? null : ReviewDTO.builder()
                .reviewId(vo.getReviewId())
                .content(vo.getContent())
                .rating(vo.getRating())
                .bookId(vo.getBookId())
                .build();
    }

    // DTO -> VO 변환
    public ReviewVO toVO() {
        return ReviewVO.builder()
                .reviewId(reviewId)
                .content(content)
                .rating(rating)
                .bookId(bookId)
                .build();
    }
}
