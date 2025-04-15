package ch04.sec04;

public class FloatCounterExample {

  public static void main(String[] args) {
    // for 문을 작성할 때는 부동 소수점을 사용하지 말아야 한다.
    for (float x = 0.1f; x <= 1.0f; x += 0.1f) {
      System.out.println(x);
    }
  }

}
