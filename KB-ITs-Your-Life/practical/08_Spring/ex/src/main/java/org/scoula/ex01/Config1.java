package org.scoula.ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 빈 생성 에제
@Configuration // 이 파일을 설정 파일로 할거야
public class Config1 {

    // 빈 생성 - 스프링이 관리하는 객체(빈)
    @Bean
    public A a1() {
        return new A();
    }
}
