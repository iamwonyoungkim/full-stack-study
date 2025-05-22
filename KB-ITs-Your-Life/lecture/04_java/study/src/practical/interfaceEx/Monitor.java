package practical.interfaceEx;

public class Monitor implements OutputDevice{
  private boolean powerStatus = false;

  @Override
  public void on() {
    powerStatus = true;
    System.out.println("Monitor의 전원을 켭니다.");
  }
  @Override
  public void off() {
    powerStatus = false;
    System.out.println("Monitor의 전원을 끕니다.");
  }
  @Override
  public void sendData(String data) {
    System.out.println("Monitor로 " + data + "를 보냅니다.");
  }

}
