package ch11.sec05;

public class ThrowsExample2 {

  // 나열해야 할 예외 클래스가 많을 경우에는 throws Exception 또는 throws Throwable 만으로 모든 예외를 떠넘길 수 있다.
  // main() 메소드에서도 예외를 떠넘길 수 있는데, 결국 JVM이 최종적으로 예외 처리를 하게 된다.
  // JVM은 예외의 내용을 콘솔에 출력하는 것으로 예외 처리를 한다.
  public static void main(String[] args) throws Exception {
    findClass();
  }

  public static void findClass() throws ClassNotFoundException {
    Class.forName("java.lang.String2");
  }

}
