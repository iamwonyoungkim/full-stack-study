package org.scoula.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// @Component Annotation: 스프링이 컨텍스트에 이 클래스의 인스턴스를 추가하도록 지시함.
@Component // 디폴트 컴포넌트의 name: 클래스명의 camelCase - parrot
public class Parrot {
    private String name;

    @PostConstruct
    public void init() {
        this.name = "Kiki";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
