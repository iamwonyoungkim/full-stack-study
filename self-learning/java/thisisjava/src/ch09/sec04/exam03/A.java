package ch09.sec04.exam03;

public class A {

  public void method1(int arg) { // final int arg
    // 로컬 변수
    int var = 1; // fianl int var = 1;

    class B {

      void method2() {
        System.out.println("arg: " + arg);
        System.out.println("var: " + var);

        // 로컬 변수 수정 불가
        // arg = 2; (x)
        // var = 2; (x)
      }
    }

    B b = new B();
    b.method2();

    // 로컬 변수 수정 불가
    // arg = 3; (x)
    // var = 3; (x)
  }

}
