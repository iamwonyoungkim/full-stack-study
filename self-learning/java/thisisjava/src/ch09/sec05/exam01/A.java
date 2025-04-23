package ch09.sec05.exam01;

public class A {

  int field1;

  void method1() {
  }

  static int field2;

  static void method2() {
  }

  class B {

    void method() {
      field1 = 10;
      method1();

      field2 = 10;
      method2();
    }
  }

  static class C {

    void method() {
      // 바깥 클래스의 인스턴스 필드와 메소드 사용 불가
      // field1 = 10;
      // method1();

      // 바깥 클래스의 정적 필드와 메소드 사용
      field2 = 10;
      method2();
    }
  }

}
