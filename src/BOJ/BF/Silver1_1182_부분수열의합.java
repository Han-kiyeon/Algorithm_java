package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver1_1182_부분수열의합.java
 *
 * @Date : 2020. 1. 26.
 * @작성자 : 한기연
 * @메모리 : 14872 kb
 * @실행시간 : 240 ms
 **/

public class Silver1_1182_부분수열의합 {
	static int N, S, ans;
	static int[] data, rlt;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();

		data = new int[N];
		for (int i = 0; i < N; i++)
			data[i] = sc.nextInt();

		visit = new boolean[N];
		for (int i = 1; i <= N; i++) {
			rlt = new int[i];
			solve(i, 0, 0);
		}
		System.out.println(ans);
	}

	private static void solve(int n, int idx, int depth) {
		if (depth == n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += rlt[i];
			}
			if (sum == S)
				ans++;
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				rlt[depth] = data[i];
				solve(n, i, depth + 1);
				visit[i] = false;
			}
		}
	}
}