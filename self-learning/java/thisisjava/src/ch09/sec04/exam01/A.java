package ch09.sec04.exam01;

// 로컬 클래스는 생성자와 메소드가 실행될 동안에만 객체를 생성할 수 있다.
public class A {

  A() {
    // 로컬 클래스 선언
    class B {

    }

    // 로컬 객체 선언
    B b = new B();
  }

  void method() {
    // Declare a local class
    class B {

    }

    // Declare a local instance
    B b = new B();
  }

}
