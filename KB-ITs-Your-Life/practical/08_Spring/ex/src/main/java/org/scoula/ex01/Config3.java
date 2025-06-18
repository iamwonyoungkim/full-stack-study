package org.scoula.ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config3 {
    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public B b(A a) {
        return new B(a);
    }

    // 생성자가 여러 개일 때 여러 형태로 빈을 생성하면
    // 와이어링은 어떻게 이루어질까?
    // 가장 많은 C c
    @Bean
    public C c1() {
        return new C();
    }

    @Bean
    public C c2(A a) {
        return new C(a);
    }

    @Bean
    public C c3(A a, B b) {
        return new C(a, b);
    }
}
