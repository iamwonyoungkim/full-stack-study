package org.scoula.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelVO {
    // csv 파일의 첫 번째 줄에 있는 각 헤더명과 동일하게 필드명 정의
    private Long no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;
}
