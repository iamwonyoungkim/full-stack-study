package dataStructure.prefixSum;

import java.util.Scanner;

public class PrefixSum4 {
    public static void main(String[] args) {
        // suNo(숫자 개수), quizNo(질의 개수) 저장하기
        Scanner sc = new Scanner(System.in);
        int suNo = sc.nextInt();
        int quizNo = sc.nextInt();
        // for(숫자 개수만큼 반복하기)
            // 합 배열 생성하기(S[i] = S[i-1] + A[i]
        int[] s = new int[suNo];
        s[0] = sc.nextInt();
        for (int i = 1; i < suNo; i++) {
            s[i] = sc.nextInt() + s[i-1];
        }
        // for(질의 개수만큼 반복하기)
            // 질의 범위 받기(i~j)
            // 구간 합 출력하기(S[j] - S[i-1])
        for (int k = 0; k < quizNo; k++) {
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;
            if (i == 0) System.out.println(s[j]);
            else System.out.println(s[j] - s[i-1]);
        }
    }
}
