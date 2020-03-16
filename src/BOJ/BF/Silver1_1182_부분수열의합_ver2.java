package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver1_1182_부분수열의합_ver2.java
 *
 * @Date : 2020. 3. 15.
 * @작성자 : 한기연
 * @메모리 : 14304 kb
 * @실행시간 : 116 ms
 *
 * @Blog : __
 **/

public class Silver1_1182_부분수열의합_ver2 {
	static int N, S, ans;
	static int[] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		ans = 0;
		solve(0, 0, 0);
		System.out.println(ans);
	}

	private static void solve(int depth, int sum, int cnt) {
		if (depth == N) {
			if (sum == S && cnt != 0)
				ans++;
			System.out.println(ans);
			return;
		}

		solve(depth + 1, sum, cnt);
		solve(depth + 1, sum + input[depth], cnt + 1);

	}
}