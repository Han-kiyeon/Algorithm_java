package BOJ.DFS_BFS;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Silver1_4963_섬의개수.java
 *
 * @Date : 2020. 2. 14.
 * @작성자 : 한기연
 * @메모리 : 32616 kb
 * @실행시간 : 312 ms
 *
 * @Blog : https://herong.tistory.com/entry/BOJ-4963-%EC%84%AC%EC%9D%98-%EA%B0%9C%EC%88%98-DFS-1
 **/

public class Silver1_4963_섬의개수 {
	static int W, H, ans;
	static int[][] map;
	// 상, 하, 좌, 우, 좌상, 좌하, 우상, 우하
	static int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		while (true) {
			W = sc.nextInt();
			if (W == 0)
				break;
			H = sc.nextInt();

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ans = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1) {
						DFS(i, j);
						ans++;

					}
				}
			}
			System.out.println(ans);
		} // end of while

	}

	private static void DFS(int i, int j) {
		for (int dir = 0; dir < dc.length; dir++) {
			int nr = i + dr[dir];
			int nc = j + dc[dir];
			if (isRange(nr, nc) && map[nr][nc] == 1) {
				map[nr][nc] = 0;
				DFS(nr, nc);
			}
		}
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < H && 0 <= nc && nc < W)
			return true;
		return false;
	}
}
