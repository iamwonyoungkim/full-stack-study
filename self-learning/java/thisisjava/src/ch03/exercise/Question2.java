package ch03.exercise;

public class Question2 {

  public static void main(String[] args) {
    int score = 85;
    String result = (!(score > 90)) ? "가" : "나";
    System.out.println(result);
  }

  // 예상 결과: 가

}
