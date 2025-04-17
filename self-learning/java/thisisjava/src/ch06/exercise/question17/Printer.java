package ch06.exercise.question17;

public class Printer {

  // static 선언 시 PrinterExample에서 Printer 객체 생성 없이 메소드 바로 이용 가능
  public static void println(int value) {
    System.out.println(value);
  }

  public static void println(boolean value) {
    System.out.println(value);
  }

  public static void println(double value) {
    System.out.println(value);
  }

  public static void println(String value) {
    System.out.println(value);
  }

}
