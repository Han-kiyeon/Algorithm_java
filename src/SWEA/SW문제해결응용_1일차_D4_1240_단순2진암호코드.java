package SWEA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결응용_1일차_D4_1240_단순2진암호코드.java
 *
 * @Date : 2019. 11. 17.
 * @작성자 : 한기연
 * @메모리 : 28,036 kb
 * @실행시간 : 156 ms
 *
 * @Blog : __
 **/
public class SW문제해결응용_1일차_D4_1240_단순2진암호코드 {
	static int N, M;
	static int[][] input;
	static int ans;
	static final int[][] code = { { 0, 0, 0, 1, 1, 0, 1 }// 0
			, { 0, 0, 1, 1, 0, 0, 1 }// 1
			, { 0, 0, 1, 0, 0, 1, 1 }// 2
			, { 0, 1, 1, 1, 1, 0, 1 }// 3
			, { 0, 1, 0, 0, 0, 1, 1 }// 4
			, { 0, 1, 1, 0, 0, 0, 1 }// 5
			, { 0, 1, 0, 1, 1, 1, 1 }// 6
			, { 0, 1, 1, 1, 0, 1, 1 }// 7
			, { 0, 1, 1, 0, 1, 1, 1 }// 8
			, { 0, 0, 0, 1, 0, 1, 1 }// 9
	};
	static int[] res;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			input = new int[8][7];
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					if (flag) // 이미 코드를 구한경우
						break;

					int tmp = str.charAt(j) - '0';
					if (tmp == 1) {
						flag = true;
						j--;
						for (int r = 0; r < 8; r++) {
							for (int c = 0; c < 7; c++) {
								input[r][c] = str.charAt(j++) - '0';
							}
						}
					}
				}
			}

			getCode();
			System.out.println("#" + tc + " " + calc());

		} // end of TC
		sc.close();
	}// end of main

	private static int calc() {
		int result = (res[0] + res[2] + res[4] + res[6]) * 3 + (res[1] + res[3] + res[5]);
		if ((result + res[7]) % 10 == 0) {
			int sum = 0;
			for (int is : res) {
				sum += is;
			}
			return sum;
		} else
			return 0;
	}

	private static void getCode() {
		res = new int[8];
		Arrays.fill(res, -1);
		for (int k = 0; k < 10; k++) {
			for (int i = 0; i < 8; i++) {
				int flag = 0;
				for (int j = 0; j < 7; j++) {
					if (input[i][j] == code[k][j])
						flag++;
				}
				if (flag == 7)
					res[i] = k;
			}
		}
		for (int i = 0; i < 8; i++) {
			if (res[i] == -1) {
				rotate();
				getCode();
				return;
			}
		}
	}

	private static void rotate() {
		int first = 0;
		for (int i = 0; i < 8; i++) {
			int[] tmp = input[i].clone();
			input[i][0] = first;
			for (int j = 1; j <= 6; j++) {
				input[i][j] = tmp[j - 1];
			}
			first = tmp[6];
		}
	}
}