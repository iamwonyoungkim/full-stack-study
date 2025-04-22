package practical.interfaceEx;

public class Mouse implements InputDevice {
  private boolean powerStatus = false;

  @Override
  public void on() {
    powerStatus = true;
    System.out.println("Mouse의 전원을 켭니다.");
  }
  @Override
  public void off() {
    powerStatus = false;
    System.out.println("Mouse의 전원을 끕니다.");
  }
  @Override
  public void getData() {
    System.out.println("Mouse의 데이터를 가져옵니다.");
  }
}
