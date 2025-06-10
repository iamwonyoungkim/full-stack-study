package org.scoula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private List<String> hobby;
}
