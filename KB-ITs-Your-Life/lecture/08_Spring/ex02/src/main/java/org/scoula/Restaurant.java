package org.scoula;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor // DI 대상을 final 변수로 하고, 이를 매개변수로 생성자 생성
public class Restaurant {
    // @Autowired
    // Autowired는 실제 운영이 아닌, 테스트에서만 사용하도록 권장됨
    private Chef chef;
}
