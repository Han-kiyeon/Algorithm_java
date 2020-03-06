package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D3_2814_최장경로.java
 *
 * @Date : 2020. 3. 4.
 * @작성자 : 한기연
 * @메모리 : 36,252 kb
 * @실행시간 : 158 ms
 *
 * @Blog : __
 **/

public class D3_2814_최장경로 {
	static int N, M;
	static boolean[] visited;
	static boolean[][] graph;
	static int ans = 0;

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
			visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

	static void dfs(int here, int depth) {
		if (ans < depth)
			ans = depth;

		for (int i = 1; i <= N; i++) {
			if (graph[here][i] && !visited[i]) {
				visited[i] = true;
				dfs(i, depth + 1);
				visited[i] = false;
			}
		}
	}
}