package org.scoula.ex02;

import org.springframework.stereotype.Controller;

@Controller
public class A {
    public A() {
        System.out.println("A");
    }

    void mA(){
        System.out.println("A의 mA() 호출");
    }
}
