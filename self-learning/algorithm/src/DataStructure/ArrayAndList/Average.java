package DataStructure.ArrayAndList;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        // 변수 n에 과목의 수 입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 길이가 n인 1차원 배열 a[] 선언하기
        int[] a = new int[n];
        // for(a[] 길이만큼 반복하기)
            // a[i]에 각 점수 저장하기
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // for(a[] 길이만큼 반복하기)
            // 최고점은 변수 max에, 총점은 변수 sum에 저장하기
        long max = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            sum += a[i];
        }
        // sum * 100 / max / n 출력하기
        System.out.println(sum * 100.0 / max / n);
    }

}
