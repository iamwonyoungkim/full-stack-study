package ch05.exercise;

public class Question7 {

  public static void main(String[] args) {
    int[] array = {1, 5, 3, 8, 2};
    int max = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    System.out.println("이 배열의 최대값: " + max);
  }

}
