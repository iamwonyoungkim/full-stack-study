package ch08.sec10.exam02;

public class CastingExample {
  // 구현클래스변수 = (구현클래스) 인터페이스변수;
  // 캐스팅 기호를 사용해서 강제 타입 변환을 해주는 경우.

  public static void main(String[] args) {
    Vehicle vehicle = new Bus();

    vehicle.run();
    // vehicle.checkFare(); (x)

    // 강제 타입 변환 후 호출
    Bus bus = (Bus) vehicle;
    bus.run();
    bus.checkFare();
  }

}
