package org.scoula.app;

import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

//        Parrot p = context.getBean(Parrot.class); // 예외 발생!!
//        System.out.println(p.getName());

        /*
            Parrot 타입으로 인스턴스가 3개 등록되어 있음 -> 3개 중 어느 것을 참조할지 결정할 수 없어 예외 발생

            타입 대신 빈의 이름으로 선택해야 함
            - @Bean 등록 시 사용한 메서드명이 빈의 기본 이름으로 등록됨
            - @Bean(name="") 또는 @Bean(value="")를 사용하여 이름 지정 가능
         */

        /*
            context.getBean(빈이름, 타입.class);
            - 타입.class: 리턴 타입으로 사용할 클래스의 class
         */
        Parrot p = context.getBean("miki", Parrot.class);
        System.out.println(p.getName());
    }
}
