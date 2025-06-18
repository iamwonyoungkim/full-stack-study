package org.scoula.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);

        A a1 = context.getBean(A.class); // context야 네가 가진 bean을 나한테 줘. 근데 A 타입을 줘

        // A a2 = context.getBean("a", A.class); // 이름을 줘서 받아오는 것도 가능. A 타입이 여러 개인 경우 이 방법 사용

        System.out.println(a1);
    }
}
