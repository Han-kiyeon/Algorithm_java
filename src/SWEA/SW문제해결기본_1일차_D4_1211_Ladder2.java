package SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_1일차_D4_1211_Ladder2.java
 *
 * @Date : 2019. 7. 18.
 * @작성자 : 한기연
 * @메모리 : 114,200 kb
 * @실행시간 : 290 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_1일차_D4_1211_Ladder2 {

	static int[][] matrix = new int[100][100];

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/1211_D4_Ladder2.txt"));
		Scanner s = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			s.nextInt(); // tc
			int I = 0, J = 0;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = s.nextInt();
				}
			}
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int j = 0; j < 100; j++)
				if (matrix[99][j] == 1) {
					I = 99;
					J = j;

					int cnt = 0;
					while (I != 0) {
						if (J != 0 && (matrix[I][J - 1] == 1)) {// 왼쪽이면
							while (J != 0 && (matrix[I][J - 1] == 1)) {
								J--;
								cnt++;
							}
							I--;
							cnt++;
						} else if (J != 99 && (matrix[I][J + 1] == 1)) {
							while (J != 99 && (matrix[I][J + 1] == 1)) {
								J++;
								cnt++;
							}
							I--;
							cnt++;
						} else {
							I--;
							cnt++;
						}
					}

					if (cnt < min) {
						min = cnt;
						idx = J;

					}
				}
			System.out.println("#" + tc + " " + idx);
		}

		s.close(); // Scanner close
	}
}
