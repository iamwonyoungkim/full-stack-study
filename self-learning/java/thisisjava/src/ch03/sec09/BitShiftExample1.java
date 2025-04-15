package ch03.sec09;

public class BitShiftExample1 {

  public static void main(String[] args) {
    int num1 = 1;
    int result1 = num1 << 3; // a << b는 a*2^b와 동일한 결과가 된다.
    int result2 = num1 * (int) Math.pow(2, 3); // Math.pow(2, 3)은 2^3을 연산하고 double 값을 산출함.
    System.out.println("result1: " + result1);
    System.out.println("result2: " + result2);

    int num2 = -8;
    int result3 = num2 >> 3; // a >> b는 a/2^b와 동일한 결과가 된다.
    int result4 = num2 / (int) Math.pow(2, 3);
    System.out.println("result3: " + result3);
    System.out.println("result4: " + result4);
  }

}
