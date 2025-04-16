package ch06.sec10.exam03;

public class Car {

  int speed;

  void run() {
    System.out.println(speed + "으로 달립니다.");
  }

  static void simulate() {
    Car myCar = new Car();
    // static method 안에서는 객체를 생성한 후에 인스턴스 멤버를 사용할 수 있다.
    myCar.speed = 200;
    myCar.run();
  }

  public static void main(String[] args) {
    // static method 호출
    simulate();

    // 객체 생성
    Car myCar = new Car();
    // 인스턴스 멤버 사용
    myCar.speed = 60;
    myCar.run();
  }

}
