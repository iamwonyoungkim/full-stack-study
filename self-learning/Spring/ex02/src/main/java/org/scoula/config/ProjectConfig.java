package org.scoula.config;

import org.scoula.beans.Parrot;
import org.scoula.beans.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.scoula.beans")
public class ProjectConfig {

    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

//    @Bean
//    public Parrot parrot2() {
//        Parrot p = new Parrot();
//        p.setName("Miki");
//        return p;
//    }

    @Bean
    public Person person(Parrot parrot) { // 메서드에 대한 매개변수 정의 -> 스프링 컨텍스트에서 빈을 제공하도록 스프링에 지시.
        Person p = new Person();
        p.setName("Ella");
        // 설정하려는 빈을 반환하는 메서드를 직접 호출하여 사람 빈과 앵무새 빈 간 관계 정의
        // 그 결과, 두 빈 사이에 has-A 관계가 생성됨. (사람은 앵무새를 소유하고 있다.)
        p.setParrot(parrot); // 스프링이 전달한 참조로 사람의 속성 값을 설정한다.
        return p;
    }
}
