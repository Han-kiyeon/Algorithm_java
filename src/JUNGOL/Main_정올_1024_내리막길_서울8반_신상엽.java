package JUNGOL;

import java.util.Scanner;

public class Main_정올_1024_내리막길_서울8반_신상엽 {
	static final int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int H, W;
	static int[][] map;
	static int[][] memo;
	static int cnt;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= H || c < 0 || c >= W) {
			return false;
		}
		return true;
	}

	static int solve(int r, int c) {
		if (memo[r][c] != -1) {
			return memo[r][c];
		}
		if (r == H - 1 && c == W - 1) {
			return 1;
		}
		memo[r][c] = 0;
		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC) && map[nextR][nextC] < map[r][c]) {
				memo[r][c] += solve(nextR, nextC);
			}
		}
		return memo[r][c];
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new int[H][W];
		memo = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
				memo[i][j] = -1;
			}
		}
		int result = solve(0, 0);
		System.out.println(result);
		sc.close();
	}
}