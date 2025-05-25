package DataStructure.ArrayAndList;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        // N값 입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 길이 N의 숫자를 입력받아 String형 변수 sNum에 저장하기
        String sNum = sc.next();
        // sNum을 다시 char[]형 변수 cNum에 변환하여 저장하기
        char[] cNum = sNum.toCharArray();
        // int형 변수 sum 선언하기
        int sum = 0;
        // for(cNum 길이만큼 반복하기)
        for (int i = 0; i < cNum.length; i++) {
            // 배열의 각 자릿값을 정수형으로 변환하며 sum에 더하여 누적하기
            sum += cNum[i] - '0';
            // sum += Character.getNumericValue(cNum[i]);
        }
        // sum 출력하기
        System.out.println(sum);
    }
}