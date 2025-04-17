package ch06.exercise.question20;

import java.util.Scanner;

public class BankApplication {

  public static void main(String[] args) {
    Account[] accounts = new Account[100];
    int i = 0;
    String targetAccount;

    Outter:
    while (true) {
      System.out.println("---------------------------------------------------");
      System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
      System.out.println("---------------------------------------------------");

      Scanner sc = new Scanner(System.in);
      System.out.print("선택> ");
      String menu = sc.nextLine();
      accounts[i] = new Account(); // Account 객체를 먼저 생성해줘야 한다.

      switch (menu) {
        case "1":
          System.out.println("--------");
          System.out.println("계좌생성");
          System.out.println("--------");

          System.out.print("계좌번호: ");
          String accountNo = sc.nextLine();
          if (accountNo.equals("")) {
            System.out.println("결과: 계좌 생성이 실패하였습니다.");
            break;
          } else {
            accounts[i].accountNo = accountNo;
          }

          System.out.print("계좌주: ");
          String name = sc.nextLine();
          if (name.equals("")) {
            System.out.println("결과: 계좌 생성이 실패하였습니다.");
            break;
          } else {
            accounts[i].accountName = name;
          }

          System.out.print("초기입금액: ");
          int balance = Integer.parseInt(sc.nextLine());
          if (balance < 0) {
            System.out.println("결과: 계좌 생성이 실패하였습니다.");
            break;
          } else {
            accounts[i].balance = balance;
          }

          i++;
          System.out.println("결과: 계좌가 생성되었습니다.");
          break;
        case "2":
          System.out.println("--------");
          System.out.println("계좌목록");
          System.out.println("--------");
          for (int j = 0; j < accounts.length; j++) {
            if (accounts[j].accountNo == null) {
              break;
            }
            System.out.println(accounts[j].accountNo + "\t" + accounts[j].accountName + "\t"
                + accounts[j].balance);
          }
          break;
        case "3":
          System.out.println("--------");
          System.out.println("예금");
          System.out.println("--------");

          System.out.print("계좌번호: ");
          targetAccount = sc.nextLine();
          System.out.print("예금액: ");
          int depositNum = Integer.parseInt(sc.nextLine());

          for (int j = 0; j < accounts.length; j++) {
            if (accounts[j].accountNo.equals(targetAccount)) {
              accounts[j].balance += depositNum;
              break;
            }
          }
          break;
        case "4":
          System.out.println("--------");
          System.out.println("출금");
          System.out.println("--------");

          System.out.print("계좌번호: ");
          targetAccount = sc.nextLine();
          System.out.print("출금액: ");
          int withdrawNum = Integer.parseInt(sc.nextLine());

          for (int j = 0; j < accounts.length; j++) {
            if (accounts[j].accountNo.equals(targetAccount)) {
              if (accounts[j].balance >= withdrawNum) {
                accounts[j].balance -= withdrawNum;
                System.out.println("결과: 출금이 성공되었습니다.");
              } else {
                System.out.println("결과: 출금이 실패하였습니다.");
              }
              break;
            }
          }
          break;
        case "5":
          break Outter;
        default:
          System.out.println("1~5 사이의 숫자만 입력 가능합니다.");
          break;
      }
    }
    System.out.println("프로그램 종료");

  }

}
