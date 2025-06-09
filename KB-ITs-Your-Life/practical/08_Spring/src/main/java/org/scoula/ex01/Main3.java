package org.scoula.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config3.class);

//        C c = context.getBean(C.class);
        // 실행 결과, 아래의 빈이 호출된다.
        //    @Bean
        //    public C c(A a, B b) {
        //        return new C(a, b);
        //    }

        C c1 = context.getBean("c1", C.class);
        C c2 = context.getBean("c2", C.class);
        C c3 = context.getBean("c3", C.class);

        context.close();

    }
}
