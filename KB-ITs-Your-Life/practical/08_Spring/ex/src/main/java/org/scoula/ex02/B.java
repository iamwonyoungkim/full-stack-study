package org.scoula.ex02;

import org.springframework.stereotype.Service;

@Service
public class B {
    public B(){
        System.out.println("B");
    }

    void mB() {
        System.out.println("B의 mB() 호출");
    }
}
