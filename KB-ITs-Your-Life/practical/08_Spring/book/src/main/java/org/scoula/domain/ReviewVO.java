package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewVO {
    private Integer reviewId;
    private String content;
    private Integer rating;
    private Integer bookId;
}
