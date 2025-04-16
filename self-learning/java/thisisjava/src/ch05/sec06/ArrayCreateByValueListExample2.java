package ch05.sec06;

public class ArrayCreateByValueListExample2 {

  public static void main(String[] args) {
    // 배열 변수 선언
    int[] scores;
    // 배열 변수에 배열을 대입
    scores = new int[]{83, 90, 87};
    // 배열 항목의 총합을 구하고 출력
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += scores[i];
    }
    System.out.println("총합: " + sum);

    // 배열을 매개값으로 주고, printItem() 메소드 호출
    printItem(new int[]{83, 90, 87});
//    printItem(scores);
//    printItem({83, 90, 87}); // 컴파일 에러
  }

  // printItem() 메소드 선언
  public static void printItem(int[] scores) {
    // 매개변수가 참조하는 배열의 항목을 출력
    for (int i = 0; i < 3; i++) {
      System.out.println("score[" + i + "]: " + scores[i]);
    }
  }

}
