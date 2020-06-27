package SWEA.문제해결_기본;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.문제해결_기본
 * @FileName : Day02_1210_Ladder1.java
 *
 * @Date : 2020. 6. 28.
 * @작성자 : 한기연
 * @메모리 : 102,196 kb
 * @실행시간 : 336 ms
 *
 * @Blog : __
 **/
public class Day02_1210_Ladder1 {
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sc.next();// 테스트 케이스 번호
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			visit = new boolean[100][100];
			for (int j = 0; j < 100; j++) {
				if (map[99][j] == 2) {
					ans = solve(99, j);
					break;
				}
			}
			System.out.println("#" + tc + " " + ans);
		} // end of TC
	}// end of Main

	private static int solve(int r, int c) {
		if (r == 0)
			return c;
		visit[r][c] = true;

		if (c - 1 >= 0 && map[r][c - 1] == 1 && !visit[r][c - 1]) {
			return solve(r, c - 1);
		} else if (c + 1 < 100 && map[r][c + 1] == 1 && !visit[r][c + 1]) {
			return solve(r, c + 1);
		} else {
			return solve(r - 1, c);
		}
	}
}