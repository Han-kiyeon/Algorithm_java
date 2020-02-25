package JUNGOL;

import java.util.Arrays;
import java.util.Scanner;

public class Main_정올_1024_내리막길_서울8반_한기연 {

	static int H, W;
	static int[][] map;
	static int[][] memoization;

	static boolean isRange(int r, int c) { // 범위안에 있으면 참
		if (r < 0 || r >= H || c < 0 || c >= W)
			return false;
		return true;
	}

	static void print(String str, int x, int y, int[][] matrix) {
		System.out.println(str + "x= " + x + ", y= " + y);
		for (int[] tmp : matrix)
			System.out.println(str + Arrays.toString(tmp));
	}

	static int solve(int r, int c) {
		if (r == H - 1 && c == W - 1) { // 최초로 목적지에 도착했을때
			return 1;
		}

		if (memoization[r][c] != -1) {// 두번째 방문일 경우
			return memoization[r][c];
		}
		// ---------------------첫번째 방문---------------------//
		memoization[r][c] = 0; // 방문 처리

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		for (int k = 0; k < 4; k++) {
			int nextR = r + dr[k];
			int nextC = c + dc[k];
			if (isRange(nextR, nextC)) // 새로운 좌표가 map안에 있고
				if (map[nextR][nextC] < map[r][c]) {// 내리막 길이면
					memoization[r][c] += solve(nextR, nextC); // DFS 결과값을 더한다.
				}
		}
		return memoization[r][c];
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		H = sc.nextInt();
		W = sc.nextInt();

		map = new int[H][W];
		memoization = new int[H][W];

		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
				memoization[i][j] = -1;
			}

		int result = solve(0, 0);
		System.out.println(result);
		sc.close();
	}
}