package ch06.sec08.exam02;

public class ComputerExample {

  public static void main(String[] args) {
    Computer myComputer = new Computer();

    int result1 = myComputer.sum(1, 2, 3);
    System.out.println("result1 : " + result1);

    int result2 = myComputer.sum(1, 2, 3, 4, 5);
    System.out.println("result2 : " + result2);

    int[] values = {1, 2, 3, 4, 5};
    int result3 = myComputer.sum(values);
    System.out.println("result3 : " + result3);

    int result4 = myComputer.sum(new int[]{1, 2, 3, 4, 5});
    System.out.println("result4 : " + result4);
  }

}
