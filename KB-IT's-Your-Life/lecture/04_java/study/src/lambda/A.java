package lambda;

public class A {
  // 정적 메소드
  static void mA(int i) {
    System.out.println(i);
  }

  // 일반 메소드
  void mB(long l) {
    System.out.println(l);
  }

  // 일반 메소드
  void mC(double d) {
    System.out.println(d);
  }

  A() {
    System.out.println("A()");
  }

  A(int i) {
    System.out.println("A(int i)");
  }

  A(String s, Integer i) {
    System.out.println("A(String s, Integer i)");
  }

}
