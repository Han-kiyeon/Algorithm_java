package SWEA.문제해결_기본;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.문제해결_기본
 * @FileName : Day03_1215_회문1.java
 *
 * @Date : 2020. 7. 2.
 * @작성자 : 한기연
 * @메모리 : 20,820 kb
 * @실행시간 : 130 ms
 *
 * @Blog : __
 **/
class Day03_1215_회문1 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 회문의 길이
			char[][] map = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			int ans = 0;
			// 가로검사
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - N; j++) {
					boolean flag = true;
					for (int k = 0; k < N / 2; k++) {
						if (map[i][j + k] != map[i][j + (N - k - 1)]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						ans++;
					}
				}
			}
			// 세로검사
			for (int j = 0; j < 8; j++) {
				for (int i = 0; i <= 8 - N; i++) {
					boolean flag = true;
					for (int k = 0; k < N / 2; k++) {
						if (map[i + k][j] != map[i + (N - k - 1)][j]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						ans++;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		} // end of TC
	}// end of main
}