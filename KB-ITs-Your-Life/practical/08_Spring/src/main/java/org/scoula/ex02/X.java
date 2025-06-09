package org.scoula.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class X {

    // @Autowired는 Bean이 생성되어 있다는 전제 하에 동작한다.
    @Autowired
    public A a; // 필드 주입

    public B b;

    @Autowired
    public X(B b) { // 생성자 주입
        this.b = b;
    }

    public C c;

    @Autowired
    void m(C c) { // 메소드 주입
        this.c = c;
    }
}
