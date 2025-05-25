package dataStructure.prefixSum;

import java.util.Scanner;

public class PrefixSum5 {
    public static void main(String[] args) {
        // N(배열 크기) M(질의 수) 저장하기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // for(N만큼 반복하기)
            // for(N만큼 반복하기)
                // 원본 배열 저장하기
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // for(N만큼 반복하기)
            // for(N만큼 반복하기)
                // 합 배열 저장하기
                // D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
        int[][] d = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = d[i][j-1] + d[i-1][j] - d[i-1][j-1] + arr[i][j];
            }
        }

        // for(M만큼 반복하기)
            // 질의 계산 및 출력하기
            // 결과 = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
        for(int i = 0; i < m; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            System.out.println(d[x2][y2] - d[x1-1][y2] - d[x2][y1-1] + d[x1-1][y1-1]);
        }
    }
}
