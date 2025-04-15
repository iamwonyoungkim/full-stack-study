package ch04.exercise;

public class Question4 {

  public static void main(String[] args) {
    while (true) {
      int dice1 = (int) (Math.random() * 6 + 1);
      int dice2 = (int) (Math.random() * 6 + 1);

      System.out.println("(" + dice1 + "," + dice2 + ")");
      if (dice1 + dice2 == 5) {
        break;
      }
    }
    System.out.println("프로그램 종료");
  }

}
