package SWEA.DFS_BFS;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.DFS_BFS
 * @FileName : D4_7699_수지의수지맞는여행.java
 *
 * @Date : 2020. 2. 18.
 * @작성자 : 한기연
 * @메모리 : 24,648 kb
 * @실행시간 : 2,068 ms
 *
 * @Blog : __
 **/

class D4_7699_수지의수지맞는여행 {
	static int T, R, C, ans;
	static char[][] map;
	static boolean[] visit;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				String str = sc.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			ans = 0;
			visit = new boolean[26];
			visit[map[0][0] - 'A'] = true;
			DFS(0, 0, 1);
			System.out.println("#" + tc + " " + ans);
		} // end of TC
	}

	private static void DFS(int i, int j, int depth) {
		if (depth > ans)
			ans = depth;
		for (int dir = 0; dir < dc.length; dir++) {
			int r = i + dr[dir];
			int c = j + dc[dir];
			if (isRange(r, c) && !visit[map[r][c] - 'A']) {
				visit[map[r][c] - 'A'] = true;
				DFS(r, c, depth + 1);
				visit[map[r][c] - 'A'] = false;
			}

		}
	}

	private static boolean isRange(int r, int c) {
		if (0 <= r && r < R && 0 <= c && c < C)
			return true;
		return false;
	}
}