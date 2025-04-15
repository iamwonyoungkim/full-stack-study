package ch04.exercise;

import java.util.Scanner;

public class Question7 {

  public static void main(String[] args) {
    int balance = 0;
    Outter:
    while (true) {
      System.out.println("--------------------");
      System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
      System.out.println("--------------------");

      Scanner sc = new Scanner(System.in);

      System.out.print("선택> ");
      String choice = sc.nextLine();
      switch (choice) {
        case "1":
          System.out.print("예금액> ");
          int deposit = Integer.parseInt(sc.nextLine());
          balance += deposit;
          break;
        case "2":
          System.out.print("출금액> ");
          int withdraw = Integer.parseInt(sc.nextLine());
          balance -= withdraw;
          break;
        case "3":
          System.out.println("잔고> " + balance);
          break;
        case "4":
          break Outter;
      }
    }
    System.out.println("프로그램 종료");
  }

}
