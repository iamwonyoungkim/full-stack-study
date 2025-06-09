package org.scoula.ex02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Bean 어노테이션으로 빈을 만들지 않았어요~
// @Autowired 필드, 생성자, 메소드 설명 추가요~
@Configuration
@ComponentScan(basePackages = "org.scoula.ex02")
public class MyConfig {

    // 눈에는 안보이지만
    // A, B, C, D 빈이 있는 거예요~
    // 그럼 와이어링은 어떻게 할 수 있나요?
}
