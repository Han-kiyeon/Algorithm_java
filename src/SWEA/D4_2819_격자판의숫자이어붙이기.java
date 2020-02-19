package SWEA;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D4_2819_격자판의숫자이어붙이기.java
 *
 * @Date : 2020. 2. 18.
 * @작성자 : 한기연
 * @메모리 : 57,648 kb
 * @실행시간 : 224 ms
 *
 * @Blog : __
 **/

class D4_2819_격자판의숫자이어붙이기 {
	static int T, N;
	static HashSet<String> set;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		N = 4;

		for (int tc = 1; tc <= T; tc++) {
			map = new int[4][4];
			set = new HashSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					DFS(i, j, 0, "" + map[i][j]);
				}
			}
			System.out.println("#" + tc + " " + set.size());

		} // end of TC
	}

	private static void DFS(int i, int j, int depth, String str) {
		if (depth == 6) {
			set.add(str);
			return;
		}
		for (int dir = 0; dir < dc.length; dir++) {
			int r = i + dr[dir];
			int c = j + dc[dir];
			if (isRange(r, c)) {
				DFS(r, c, depth + 1, str + map[r][c]);
			}
		}
	}

	private static boolean isRange(int r, int c) {
		if (0 <= r && r < 4 && 0 <= c && c < 4)
			return true;
		return false;
	}
}
