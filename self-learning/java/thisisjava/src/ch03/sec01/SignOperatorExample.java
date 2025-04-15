package ch03.sec01;

public class SignOperatorExample {

  public static void main(String[] args) {
    int x = -100;
    x = -x;
    System.out.println("x: " + x);

    byte b = 100;
    int y = -b; // 정수 타입(byte, short, int) 연산의 결과는 int 타입. 결과값을 byte에 대입하면 오류 발생.
    System.out.println("y: " + y);
  }

}
