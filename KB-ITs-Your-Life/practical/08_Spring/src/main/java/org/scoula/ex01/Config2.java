package org.scoula.ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {

    // 빈 생성
    @Bean
    public A a() {
        return new A();
    }

//    @Bean
//    public B b() {
//        return new B(a());
//    }

    // 와이어링
    // Bean이 있는 경우 매개변수의 변수 a에 new A()가 주입된다.
    @Bean
    public B b(A a) { // a = new A()
        return new B(a);
    }
}
