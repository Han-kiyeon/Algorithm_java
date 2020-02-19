package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D2_1961_숫자배열회전.java
 *
 * @Date : 2019. 11. 17.
 * @작성자 : 한기연
 * @메모리 : 26,652 kb
 * @실행시간 : 143 ms
 *
 * @Blog : __
 **/
public class D2_1961_숫자배열회전 {
	static int N;
	static int[][] matrix;
	static int[][][] res;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);

			N = sc.nextInt();
			matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			rotate();
			print();
		} // end of TC
	}// end of Main

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < N; j++) {
					System.out.print(res[k][i][j]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void rotate() {
		res = new int[3][N][N];
		for (int k = 0; k < 3; k++) {
			int r = 0, c = 0;
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) {
					res[k][r][c++] = matrix[i][j];
					if (c == N) {
						r++;
						c = 0;
					}

				}
			}

			for (int i = 0; i < N; i++) {
				matrix[i] = res[k][i].clone();
			}
		}
	}
}