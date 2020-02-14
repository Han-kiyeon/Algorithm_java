package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver5_2422_한윤정이이탈리아에가서아이스크림을사먹는데.java
 *
 * @Date : 2020. 2. 14.
 * @작성자 : 한기연
 * @메모리 : 34032 kb
 * @실행시간 : 404 ms
 *
 * @Blog : __
 **/

public class Silver5_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {
	static int N, M, ans;
	static boolean[][] graph;
	static boolean[] visit;
	static int[] data = new int[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		graph = new boolean[N][N];
		visit = new boolean[N];

		for (int i = 0; i < M; i++) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;
			graph[s][e] = true;
			graph[e][s] = true;
		}
		ans = 0;
		solve(0, 0);
		System.out.println(ans);

	}

	private static void solve(int index, int depth) {
		if (depth == 3) {
			if (check())
				ans++;
			return;
		}
		for (int i = index; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				data[depth] = i;
				solve(i, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static boolean check() {
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (graph[data[i]][data[j]])
					return false;
			}
		}
		return true;
	}
}
