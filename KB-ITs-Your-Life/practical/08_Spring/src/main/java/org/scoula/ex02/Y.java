package org.scoula.ex02;

import org.springframework.stereotype.Component;

// 오토 와이어링 추천 코드
@Component
public class Y {

    private final A a;

    // @Autowired // 여기서는 생략해도 됨. final 로 되어 있고, 생성자가 하나 뿐이기 때문.
    public Y(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }
}
