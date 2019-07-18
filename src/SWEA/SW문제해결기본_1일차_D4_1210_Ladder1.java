package SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_1일차_D4_1210_Ladder1.java
 *
 * @Date : 2019. 7. 18.
 * @작성자 : 한기연
 * @메모리 : 110,772 kb
 * @실행시간 : 266 ms
 *
 * @Blog : __
 **/


public class SW문제해결기본_1일차_D4_1210_Ladder1 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/1210_D4_Ladder1.txt"));
		Scanner s = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			s.nextInt(); // tc
			int I = 0, J = 0;

			int[][] matrix = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = s.nextInt();
				}
			}

			for (int j = 0; j < 100; j++)
				if (matrix[99][j] == 2) {
					I = 99;
					J = j;
				}

			while (I != 0) {
				if (J != 0 && (matrix[I][J - 1] == 1)) {// 왼쪽이면
					while (J != 0 && (matrix[I][J - 1] == 1))
						J--;
					I--;
				} else if (J != 99 && (matrix[I][J + 1] == 1)) {
					while (J != 99 && (matrix[I][J + 1] == 1))
						J++;
					I--;
				} else {
					I--;
				}
			}

			System.out.println("#" + tc + " " + J);
		}

		s.close(); // Scanner close
	}
}
