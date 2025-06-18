package org.scoula.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);

        B b = context.getBean(B.class);

        b.a.m();

        context.close();
    }
}
