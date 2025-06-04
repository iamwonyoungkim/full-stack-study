package org.scoula.jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {
    private Integer id;
    private String name;
    private Integer price;
    private LocalDate regDate;
    private LocalDateTime updateAt;
    private Boolean ebook;
    
    private BookDetailVO bookDetail;

    private List<BookReviewVO> reviews;
}
