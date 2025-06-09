package org.scoula.ex01;

public class B {

    public A a;

    public B() {}

    public B(A a) {
        this.a = a;
        System.out.println("B.A");
    }
}
