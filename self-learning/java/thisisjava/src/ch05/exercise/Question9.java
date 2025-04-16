package ch05.exercise;

import java.util.Scanner;

public class Question9 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int studentNum = 0;
    int[] scores = null;
    Outter:
    while (true) {
      System.out.println("--------------------------------------------------------");
      System.out.println("1. 학생수 | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
      System.out.println("--------------------------------------------------------");
      System.out.print("선택> ");
      int menu = Integer.parseInt(sc.nextLine());
      switch (menu) {
        case 1:
          System.out.print("학생 수> ");
          studentNum = Integer.parseInt(sc.nextLine());
          break;
        case 2:
          scores = new int[studentNum];
          for (int i = 0; i < studentNum; i++) {
            System.out.print("scores[" + i + "]> ");
            scores[i] = Integer.parseInt(sc.nextLine());
          }
          break;
        case 3:
          for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
          }
          break;
        case 4:
          int max = scores[0];
          int sum = scores[0];
          for (int i = 1; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > max) {
              max = scores[i];
            }
          }
          double avg = (double) sum / scores.length;
          System.out.println("최고 점수: " + max);
          System.out.println("평균 점수: " + avg);
          break;
        case 5:
          break Outter;
      }
    }
    System.out.println("프로그램 종료");
  }

}
