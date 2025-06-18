package org.scoula.ex01;

public class C {

    private A a;
    private B b;

    public C() {
        System.out.println("C.C");
    }

    public C(A a) {
        System.out.println("C.A");
    }

    public C(A a, B b) {
        System.out.println("C.A.B");
    }
}
