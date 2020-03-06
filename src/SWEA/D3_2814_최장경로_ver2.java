package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D3_2814_최장경로_ver2.java
 *
 * @Date : 2020. 3. 6.
 * @작성자 : 한기연
 * @메모리 : 38,728 kb
 * @실행시간 : 153 ms
 *
 * @Blog : __
 **/

public class D3_2814_최장경로_ver2 {
	static int N, M;
	static boolean[][] graph;
	static int ans = 0;
	static int[][] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			graph = new boolean[N + 1][N + 1];
			for (int m = 0; m < M; m++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph[u][v] = graph[v][u] = true;
			}

			ans = 0;
			// 방문한 값을 비트로
			memo = new int[1 << (N + 1)][N + 1];
			for (int i = 1; i <= N; i++) {
				ans = Math.max(ans, dfs(i, 1 << i));
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

	static int dfs(int here, int visit) {
		if (memo[visit][here] != 0)
			return memo[visit][here];

		int ret = 1;
		for (int i = 1; i <= N; i++) {
			if (graph[here][i] && (visit & (1 << i)) == 0) {
				ret = Math.max(ret, dfs(i, visit | (1 << i)) + 1);
			}
		}
		memo[visit][here] = ret;
		return ret;
	}
}