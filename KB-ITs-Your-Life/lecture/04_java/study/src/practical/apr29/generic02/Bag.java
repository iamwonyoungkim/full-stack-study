package practical.apr29.generic02;

public class Bag {
  // 클래스명에 <타입>이 없고, 메소드 안에서만 제네릭을 사용하겠다
  // -> 메소드의 리턴 타입 앞에 <타입>을 붙여줘야 한다.
  public <T> void put(T t) {
    System.out.println("put " + t);
  }

  // Car를 Bag에 넣는 건 말이 안된다.
  // Car를 못 넣게 하려면??
  public <T extends Item> void put2(T t) {
    System.out.println("put " + t);
  }

}
