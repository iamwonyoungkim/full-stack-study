package ch02.sec01;

public class VariableInitializationExample {
    public static void main(String[] args) {
//        int value; 처럼 선언만 하고 초기화를 안시켜주면 아래 result에서 값을 사용할 수 없다.
        int value = 30;

        int result = value + 10;

        System.out.println(result);
    }
}
