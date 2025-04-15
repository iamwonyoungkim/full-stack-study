package ch03.exercise;

public class Question5 {

  public static void main(String[] args) {
    int lengthTop = 5;
    int lengthBottom = 10;
    int height = 7;
//    double area = (lengthTop + lengthBottom) * height / 2.0; // (o)
//    double area = (lengthTop + lengthBottom) * height * 1.0 / 2; // (x) -> (o)
//    double area = (double) (lengthTop + lengthBottom) * height / 2; // (o)
    double area = (double) ((lengthTop + lengthBottom) * height
        / 2); // (o) -> (x) 나눗셈 결과가 int로 들어갔다가 double로 강제 형변환하므로, 소수점 아래의 정보는 없어서 52.5가 아닌 52.0으로 출력된다.
    System.out.println(area);
  }
}
