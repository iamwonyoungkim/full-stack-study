package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookVO {
    private Integer bookId;
    private String title;

    private BookDetailVO bookDetail; // 1:1 관계
    private List<ReviewVO> reviews;  // 1:다 관계
}
