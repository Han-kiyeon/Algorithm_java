package SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_3일차_D3_1215_회문1.java
 *
 * @Date : 2019. 7. 23.
 * @작성자 : 한기연
 * @메모리 : 27,096 kb
 * @실행시간 : 146 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_3일차_D3_1215_회문1 {

	public static int solve(int a, char[][] matrix) {
		int cnt = 0;

		int head, tail;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <= matrix[i].length - a; j++) {
				// 가로 탐색
				head = 0;
				tail = a - 1;
				while (head <= tail) {
					if (matrix[i][j + head] == matrix[i][j + tail]) {
						head++;
						tail--;
					} else
						break;
				}
				if (head > tail) {
					cnt++;
				}
			}
		}

		for (int i = 0; i <= matrix.length - a; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// 가로 탐색
				head = 0;
				tail = a - 1;
				while (head <= tail) {
					if (matrix[i + head][j] == matrix[i + tail][j]) {
						head++;
						tail--;
					} else
						break;
				}
				if (head > tail) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1215_D3_회문1.txt"));
		Scanner s = new Scanner(System.in);

		int T = 10;
		char[][] matrix = new char[8][8];
		int a;
		for (int tc = 1; tc <= T; tc++) {

			a = s.nextInt();

			for (int i = 0; i < 8; i++) {
				char[] row = s.next().toCharArray();
				for (int j = 0; j < 8; j++) {
					matrix[i][j] = row[j];
				}
			}

			int ans = solve(a, matrix);

			System.out.println("#" + tc + " " + ans);
		}

		s.close(); // Scanner close
	}
}
