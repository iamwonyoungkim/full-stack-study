package ch09.sec07.exam01;

public class Car {

  private Tire tire1 = new Tire();

  // v필드에 익명 자식 객체 대입
  private Tire tire2 = new Tire() {
    @Override
    public void roll() {
      System.out.println("익명 자식 Tire 객체 1이 굴러갑니다.");
    }
  };

  public void run1() {
    tire1.roll();
    tire2.roll();
  }

  public void run2() {
    // 로컬 변수에 익병 자식 객체 대입
    Tire tire = new Tire() {
      @Override
      public void roll() {
        System.out.println("익명 자식 Tire 객체 2가 굴러갑니다.");
      }
    };
    tire.roll();
  }

  public void run3(Tire tire) {
    tire.roll();
  }
}
