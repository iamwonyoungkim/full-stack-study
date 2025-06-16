package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    스프링은 Bean으로 등록된 객체만 관리할 수 있다.
    스프링 컨텍스트에 빈을 추가하는 단계
        1. @Configuration으로 구성 클래스 정의
           - 스프링 컨텍스트 구성 시 사용
        2. 컨텍스트에 추가하려는 객체 인스턴스를 반환하는 메서드를 구성하는 클래스에 추가,
           해당 메서드에 @Bean 어노테이션 추가
        3. 스프링이 1에서 정의한 구성 클래스 사용 <- Main.java 확인
 */
@Configuration // 구성 클래스 정의 - 스프링 컨텍스트 구성 시 사용
public class ProjectConfig {
    // 빈을 반환하는 메서드를 생성하고 Bean 어노테이션을 메서드에 추가하기
    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    // 다른 Bean들 더 추가
    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
}
