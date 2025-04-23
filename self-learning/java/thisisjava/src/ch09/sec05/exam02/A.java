package ch09.sec05.exam02;

// 중첩 클래스 내부에서 바깥 클래스의 객체를 얻으려면 바깥 클래스 이름에 this를 붙여 주면 된다
// 바깥클래스이름.this -> 바깥객체
public class A {

  String field = "A-field";

  void method() {
    System.out.println("A-method");
  }

  class B {

    String field = "B-field";

    void method() {
      System.out.println("B-method");
    }

    void print() {
      // B(중첩 클래스) 객체의 필드와 메소드
      System.out.println(this.field);
      this.method();

      // A(바깥 클래스) 객체의 필드와 메소드 사용
      System.out.println(A.this.field);
      A.this.method();
    }
  }

  void useB() {
    B b = new B();
    b.print();
  }

}
