package dataStructure.prefixSum;

import java.util.Scanner;

public class ModuloSum {
    public static void main(String[] args) {
        long answer = 0;
        Scanner sc = new Scanner(System.in);
        // 수열의 개수 n 입력받기
        int n = sc.nextInt();
        // 나누어떨어져야 하는 수 m 입력받기
        int m = sc.nextInt();
        // 합 배열 s 선언하기
        long[] s = new long[n];
        // 같은 나머지의 인덱스를 카운트하는 배열 c 선언하기
        long[] c = new long[m];
        // for (i -> 1 ~ n)
            // s[i] = s[i-1] + a[i]
        s[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            s[i] = s[i-1] + sc.nextInt();
        }
        // for (i -> 0 ~ n)
            // remainder = s[i] % m // 합 배열을 m으로 나눈 나머지 값
            // if(remainder == 0) 정답을 1 증가시키기
            // c[remainder]의 값을 1 증가시키기
        for (int i = 0; i < n; i++) {
            int remainder = (int) (s[i] % m);
            if(remainder == 0) answer++;
            c[remainder]++;
        }
        // for (i -> 0 ~ m)
            // c[i](i가 나머지인 인덱스의 개수)에서 2가지를 뽑는 경우의 수를 정답에 더하기
            // c[i]개 중 2개를 뽑는 경우의 수 계산 공식 c[i] * (c[i] - 1) / 2
        for (int i = 0; i < m; i++) {
            if (c[i] > 1) answer += c[i] * (c[i] - 1) / 2;
        }
        // 결괏값 출력
        System.out.println(answer);
    }
}
