package ch03.exercise;

public class Question1 {

  public static void main(String[] args) {
    int x = 10;
    int y = 20;
    int z = (++x) + (y--);
    System.out.println(z);
  }

  // 예상 결과: 31

}
