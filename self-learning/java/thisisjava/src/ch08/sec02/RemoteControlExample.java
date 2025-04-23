package ch08.sec02;

public class RemoteControlExample {

  public static void main(String[] args) {
//    RemoteControl rc;
//    rc = new Television();
    RemoteControl rc = new Television();

    rc.turnOn(); // Television 클래스의 turnOn() 메소드가 실행된다.

    rc = new Audio();
    rc.turnOn(); // Audio 클래스의 turnOn() 메소드가 실행된다.
  }

}
