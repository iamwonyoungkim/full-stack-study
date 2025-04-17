package ch06.exercise.question19;

public class Account {

  int balance;
  static final int MIN_BALANCE = 0;
  static final int MAX_BALANCE = 1000000;

  void setBalance(int balance) {
    if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
      this.balance = balance;
    }
  }

  int getBalance() {
    return balance;
  }

}
