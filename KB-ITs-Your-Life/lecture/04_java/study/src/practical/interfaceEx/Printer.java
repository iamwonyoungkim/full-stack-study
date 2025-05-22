package practical.interfaceEx;

public class Printer implements OutputDevice {
  private boolean powerStatus = false;

  @Override
  public void on() {
    powerStatus = true;
    System.out.println("Printer의 전원을 켭니다.");
  }
  @Override
  public void off() {
    powerStatus = false;
    System.out.println("Printer의 전원을 끕니다.");
  }
  @Override
  public void sendData(String data) {
    System.out.println("Printer로 " + data + "를 보냅니다.");
  }

  // default 메소드도 재정의 가능하다.
  @Override
  public void reset() {
    off();
    System.out.println("10초 기다린다.");
    on();
  }
}
