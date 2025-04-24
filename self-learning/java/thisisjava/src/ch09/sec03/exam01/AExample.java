package ch09.sec03.exam01;

public class AExample {

  public static void main(String[] args) {
    // A 클래스 외부에서 정적 멤버 클래스 B의 객체를 생성하려면
    // A 객체 생성 없이 A 클래스로 접근해서 B 객체를 생성할 수 있다.
    A.B b = new A.B();
  }

}
