package JUNGOL;

import java.util.*;

public class Main_정올_2000_동전교환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] coin = new int[N];

		for (int i = 0; i < N; i++)
			coin[i] = sc.nextInt();

		int W = sc.nextInt();
		int[] dp = new int[W + 1];

		for (int i = 1; i <= W; i++) {
			int min = Integer.MAX_VALUE / 2;
			for (int j = 0; j < N; j++) {
				if (i - coin[j] >= 0) {
					min = min > (dp[i - coin[j]] + 1) ? (dp[i - coin[j]] + 1) : min;
				}
			}

			dp[i] = min;

		}
		// System.out.println(dp.length);
		// System.out.println(Arrays.toString(dp));
		if (dp[W] == Integer.MAX_VALUE / 2)
			System.out.println("impossible");
		else
			System.out.println(dp[W]);

		sc.close();
	}

}