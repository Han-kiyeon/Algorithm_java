package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D4_4613_러시아국기같은깃발.java
 *
 * @Date : 2019. 11. 17.
 * @작성자 : 한기연
 * @메모리 : 28,928 kb
 * @실행시간 : 175 ms
 *
 * @Blog : __
 **/
public class D4_4613_러시아국기같은깃발 {
	static int N, M;
	static char[][] map;
	static int ans;
	static int[] match;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			ans = Integer.MAX_VALUE;
			match = new int[2];
			visit = new boolean[N - 1];
			get(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void get(int start, int depth) {
		if (depth == 2) {
			solve();
			return;
		}
		for (int i = start; i < N - 1; i++) {
			if (!visit[i]) {
				visit[i] = true;
				match[depth] = i;
				get(i, depth + 1);
				visit[i] = false;
			}
		}

	}

	private static void solve() {
		int cnt = 0;
		// W
		for (int i = 0; i <= match[0]; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 'W')
					cnt++;
			}
		}
		// B
		for (int i = match[0] + 1; i <= match[1]; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 'B')
					cnt++;
			}
		}
		// R
		for (int i = match[1] + 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 'R')
					cnt++;
			}
		}

		if (ans > cnt)
			ans = cnt;
	}
}