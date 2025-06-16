package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // 새로 생성된 구성 클래스로 스프링이 컨텍스트를 초기화하도록 만들기
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        /*
            AnnotationConfigApplicationContext(구성클래스);
                - 구성 클래스로 컨텍스트를 만들도록 하는 클래스
                - 구성 클래스의 class를 매개변수로 지정
         */

        // Context에서 원하는 Bean 객체 추출하기
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);
        // 동일한 타입에 대해서는 1개의 Bean만 추출할 수 있다.
    }
}
