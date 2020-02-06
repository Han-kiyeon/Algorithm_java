import java.util.Scanner;

public class Main {
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