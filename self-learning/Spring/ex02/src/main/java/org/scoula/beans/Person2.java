package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person2 {
    private String name = "Ella";

    // 스프링이 스프링 컨텍스트에서 빈을 가져와 @Autowired Annotation된 필드 값에 직접 설정하도록 지시.
    // 이렇게 하면 두 빈 사이에 관계가 설정된다.
    @Autowired
    private Parrot2 parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot2 getParrot() {
        return parrot;
    }

    public void setParrot(Parrot2 parrot) {
        this.parrot = parrot;
    }
}
