package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;

    private Parrot parrot; // Person이 Parrot을 소유하도록 설정할 것이다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    // setter를 이용한 의존성 주입 사용
    @Autowired
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
