package ch04.sec07;

public class BreakOutterExample {

  public static void main(String[] args) throws Exception {
    // 바깥쪽 for문까지 빠져나오도록 바깥쪽 for 문에 Outter라는 라벨을 붙인다.
    Outter:
    for (char upper = 'A'; upper <= 'Z'; upper++) {
      for (char lower = 'a'; lower <= 'z'; lower++) {
        System.out.println(upper + "-" + lower);
        if (lower == 'g') {
          break Outter;
        }
      }
    }
    System.out.println("프로그램 실행 종료");
  }

}
