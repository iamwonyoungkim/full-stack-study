package ch11.sec06;

// 잔고 부족 예외를 사용자 정의 예외 클래스로 선언
public class InsufficientException extends Exception { // 일반 예외로 선언

  public InsufficientException() {
  }

  public InsufficientException(String message) {
    super(message);
  }
}
