package ch11.sec05;

public class ThrowsExample1 {

  public static void main(String[] args) {
    // 메소드 내부가 아닌 호출한 곳에서 예외 처리
    try {
      findClass();
    } catch (ClassNotFoundException e) {
      System.out.println("예외 처리: " + e.toString());
    }
  }

  // 예외 떠넘기기
  public static void findClass() throws ClassNotFoundException {
    Class.forName("java.lang.String2");
  }

}
