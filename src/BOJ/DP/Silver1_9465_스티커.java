package BOJ.DP;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DP
 * @FileName : Silver1_9465_스티커.java
 *
 * @Date : 2020. 1. 27.
 * @작성자 : 한기연
 * @메모리 : 287096 kb
 * @실행시간 : 1412 ms
 **/

public class Silver1_9465_스티커 {

	static int T, n;
	static int[][] data, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {

			n = sc.nextInt();
			data = new int[2][n + 1];
			dp = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= n; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			dp[0][1] = data[0][1];
			dp[1][1] = data[1][1];

			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + data[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + data[1][i];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}