package ch06.sec12.hyundai;

import ch06.sec12.hankook.SnowTire;
import ch06.sec12.kumho.AllSeasonTire;

public class Car {

  // 서로 다른 패키지에 동일한 클래스 이름이 존재하는 경우,
  // 클래스의 전체 이름을 사용해서 정확히 어떤 패키지의 클래스를 사용하는지 알려야 한다.
  ch06.sec12.hankook.Tire tire1 = new ch06.sec12.hankook.Tire();
  ch06.sec12.kumho.Tire tire2 = new ch06.sec12.kumho.Tire();
  SnowTire tire3 = new SnowTire();
  AllSeasonTire tire4 = new AllSeasonTire();

}
