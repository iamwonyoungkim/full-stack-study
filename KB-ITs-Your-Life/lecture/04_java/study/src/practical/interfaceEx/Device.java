package practical.interfaceEx;

// 인터페이스 구성 요소
public interface Device {
  // 1.상수 필드
  // 모든 기기에 붙는 공통 접두사
  public static final String PREFIX = "DEVICE_";

  // 2.추상 메소드
  // 모든 기기가 반드시 구현해야 하는 기본 동작
  public abstract void on();   // 기기 전원 켜기

  public abstract void off();  // 기기 전원 끄기

  // 3.디폴트 메소드
  // 공통으로 사용할 수 있는 기본 구현
  public default void reset() {
    System.out.println("reset 하기 가장 쉬운 방법");
    off();  // 전원을 끈 후
    on();   // 다시 켜기
  }

  // 4.정적 메소드: 기기 타입 확인 기능
  public static String checkDeviceType(Device d) {
    if (d instanceof InputDevice) {
      return "Input Device";
    } else if (d instanceof OutputDevice) {
      return "Output Device";
    }
    return "Unknown Device Type";
  }
}