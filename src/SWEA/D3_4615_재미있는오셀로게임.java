package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D3_4615_재미있는오셀로게임.java
 *
 * @Date : 2019. 11. 16.
 * @작성자 : 한기연
 * @메모리 : 33,700 kb
 * @실행시간 : 165 ms
 *
 * @Blog : __
 **/
public class D3_4615_재미있는오셀로게임 {
	static int N;// 보드 한변의 길이 (4, 6, 8 중 하나)
	static int M;// 플레이어가 돌을 놓는 횟수

	// 상, 하, 좌, 우, 좌상, 우하, 우상, 좌하
	static final int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static final int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 };

	static int[][] map;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			init();
			for (int i = 0; i < M; i++) {
				int r = sc.nextInt() - 1;
				int c = sc.nextInt() - 1;
				int player = sc.nextInt();// 1이면 흑돌 2이면 백돌
				put(r, c, player);
			}
			System.out.println("#" + tc + " " + sum());
		} // end of TC
		sc.close();
	}

	private static String sum() {
		int[] res = new int[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					res[0]++;
				else if (map[i][j] == 2)
					res[1]++;
			}
		}
		return res[0] + " " + res[1];
	}

	private static void init() {
		map = new int[N][N];
		int half = N / 2;
		map[half - 1][half] = 1;
		map[half][half - 1] = 1;
		map[half - 1][half - 1] = 2;
		map[half][half] = 2;
	}

	private static void put(int r, int c, int player) {
		map[r][c] = player;
		for (int dir = 0; dir < 8; dir++) {
			check(r, c, dir);
		}
	}

	private static void check(int r, int c, int dir) {
		int nr = r + dr[dir];
		int nc = c + dc[dir];

		while (true) {
			if (!isRange(nr, nc) || map[nr][nc] == 0)
				break;

			if (map[r][c] != map[nr][nc]) {
				nr += dr[dir];
				nc += dc[dir];
			} else
				break;
		}

		if (isRange(nr, nc) && map[nr][nc] == map[r][c]) {
			while (r != nr || c != nc) {
				map[nr][nc] = map[r][c];
				nr -= dr[dir];
				nc -= dc[dir];
			}
		}

	}

	private static boolean isRange(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < N)
			return true;
		return false;
	}
}
