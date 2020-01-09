package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_2일차_D3_1209_Sum.java
 *
 * @Date : 2020. 01. 09.
 * @작성자 : 한기연
 * @메모리 : 96,804 kb
 * @실행시간 : 328 ms
 *
 * @Blog : __
 **/

public class SW문제해결기본_2일차_D3_1209_Sum {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {

			int tcNum = s.nextInt();

			int[][] matrix = new int[100][100];

			int line1 = 0;
			int line2 = 0;

			int[] sumRow = new int[100];
			int[] sumCol = new int[100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = s.nextInt();
					sumRow[i] += matrix[i][j];
					sumCol[j] += matrix[i][j];
					if (i == j)
						line1 += matrix[i][j];
					else if ((99 - i) == j)
						line2 += matrix[i][j];
				}
			}

			int max = line1;
			for (int i = 0; i < 100; i++) {
				if (max < sumRow[i])
					max = sumRow[i];
				if (max < sumCol[i])
					max = sumCol[i];
			}

			if (max < line2)
				max = line2;

			System.out.println("#" + tcNum + " " + max);
		}
		s.close(); // Scanner close
	}
}