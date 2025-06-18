package org.scoula.ex02;

import org.springframework.stereotype.Repository;

@Repository
public class C {
    public C() {
        System.out.println("C");
    }

    void mC(){
        System.out.println("C의 mC() 호출");
    }
}
