package BOJ.Simulation;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Gold5_14503_로봇청소기.java
 *
 * @Date : 2020. 3. 7.
 * @작성자 : 한기연
 * @메모리 : 19168 kb
 * @실행시간 : 172 ms
 *
 * @Blog : __
 **/
public class Gold5_14503_로봇청소기 {
	static int N, M;
	static int[][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		int r = sc.nextInt();
		int c = sc.nextInt();
		int dir = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		}
		ans = 0;
		solve(r, c, dir);

		System.out.println(ans);
	}

	static void solve(int r, int c, int dir) {

		switch (map[r][c]) {
		case 1:
			return;
		case 0:
			map[r][c] = -1;
			ans++;
		}
		int nDir = dir;
		for (int i = 0; i < 4; i++) {
			nDir = (nDir + 3) % 4;
			int nR = r + dr[nDir];
			int nC = c + dc[nDir];

			if (map[nR][nC] == 0) {
				solve(nR, nC, nDir);
				return;
			}
		}
		solve(r - dr[dir], c - dc[dir], dir);
		return;
	}
}