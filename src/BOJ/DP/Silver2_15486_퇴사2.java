package BOJ.DP;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DP
 * @FileName : Silver2_15486_퇴사2.java
 *
 * @Date : 2020. 2. 6.
 * @작성자 : 한기연
 * @메모리 : 370112 kb
 * @실행시간 : 2232 ms
 *
 * @Blog : __
 **/

public class Silver2_15486_퇴사2 {
	public static void main(String[] z) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] dp = new int[N + 50];

		for (int i = 1; i <= N; i++) {
			int T = s.nextInt();
			int P = s.nextInt();
			dp[i] = Math.max(dp[i - 1], dp[i]);
			dp[i + T - 1] = Math.max(dp[i + T - 1], dp[i - 1] + P);
		}
		System.out.print(dp[N]);
	}
}