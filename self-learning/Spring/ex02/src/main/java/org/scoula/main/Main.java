package org.scoula.main;

import org.scoula.beans.Parrot;
import org.scoula.beans.Person;
import org.scoula.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);

        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());

        System.out.println("Person's parrot: " + person.getParrot());

        /*
        Peron 생성자에 매개변수와 메서드를 작성하기 전 실행 결과:
            Person's name: Ella
            Parrot's name: Koko
            Person's parrot: null
        사람이 아직 앵무새를 소유하고 있지 않다.
        즉, 두 Bean은 Context에 있지만 서로 연결되어 있지 않다.
         */
    }
}
