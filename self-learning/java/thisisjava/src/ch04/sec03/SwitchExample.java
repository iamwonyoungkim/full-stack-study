package ch04.sec03;

public class SwitchExample {

  public static void main(String[] args) {
    int num = (int) (Math.random() * 6) + 1;

    switch (num) {
      case 1:
        System.out.println("1번이 나왔습니다.");
        break; // break가 없다면 다음 case가 case 값과 상관없이 연달아 실행된다.
      case 2:
        System.out.println("2번이 나왔습니다.");
        break;
      case 3:
        System.out.println("3번이 나왔습니다.");
        break;
      case 4:
        System.out.println("4번이 나왔습니다.");
        break;
      case 5:
        System.out.println("5번이 나왔습니다.");
        break;
      default: // 변수 값과 동일한 값을 갖는 case가 없으면 default로 가서 실행문을 실행시킨다. (생략 가능)
        System.out.println("6번이 나왔습니다.");
    }
  }

}
