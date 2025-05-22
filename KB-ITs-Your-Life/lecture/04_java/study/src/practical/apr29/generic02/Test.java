package practical.apr29.generic02;

public class Test {

  public static void main(String[] args) {
    Bag bag = new Bag();
    bag.put(new Earphone());
    bag.put(new SmartPhone());
    bag.put(new Car());

    System.out.println();

    bag.put2(new Earphone());
    bag.put2(new SmartPhone());
    // bag.put2(new Car()); -> 에러 발생
  }

}
