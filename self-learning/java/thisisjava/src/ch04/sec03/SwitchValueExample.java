package ch04.sec03;

public class SwitchValueExample {

  public static void main(String[] args) {
    String grade = "B";

    int score = switch (grade) {
      case "A" -> 100;
      case "B" -> {
        int result = 100 - 20;
        yield result; // 스위치된 값을 변수에 바로 대입할 수 있다.
      }
      default -> 60;
    };
    System.out.println("score: " + score);
  }

}
