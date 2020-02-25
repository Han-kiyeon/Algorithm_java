package JUNGOL;

import java.util.*;


public class Main_정올_2000_동전교환2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] coin = new int[N];

		for (int i = 0; i < N; i++)
			coin[i] = sc.nextInt();
		
		Arrays.sort(coin);

		int W = sc.nextInt();
		int[][] dp = new int[coin.length][W + 1];

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= W; j++) {
				if(i<1) 
					dp[i][j] = dp[i][j-coin[i]]+1;
				else if(j<coin[i])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.min(dp[i][j-coin[i]]+1, dp[i-1][j]);
			}
		}

		// System.out.println(dp.length);
		// System.out.println(Arrays.toString(dp));
		if (dp[N-1][W] == Integer.MAX_VALUE / 2)
			System.out.println("impossible");
		else
			System.out.println(dp[N-1][W]);

		sc.close();
	}

}