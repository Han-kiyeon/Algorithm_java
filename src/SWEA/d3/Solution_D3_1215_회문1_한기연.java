package com.d3;

import java.io.*;
import java.util.*;

public class Solution_D3_1215_회문1_한기연 {

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
					//System.out.print("[" + i + "][" + j + "]>");
					//for (int k = 0; k < a; k++)
					//	System.out.print(matrix[i][j + k]);
					//System.out.println();
				}
			}
		}
		
		for (int i = 0; i <= matrix.length-a; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// 가로 탐색
				head = 0;
				tail = a - 1;
				while (head <= tail) {
					if (matrix[i+head][j] == matrix[i+tail][j]) {
						head++;
						tail--;
					} else
						break;
				}
				if (head > tail) {
					cnt++;
//					System.out.print("[" + i + "][" + j + "]^");
//					for (int k = 0; k < a; k++)
//						System.out.print(matrix[i + k][j]);
//					System.out.println();
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
			
//			for(char[] b :matrix)
//				System.out.println(Arrays.toString(b));

			int ans = solve(a, matrix);

			System.out.println("#" + tc + " " + ans);
		}

		s.close(); // Scanner close
	}
}

/*
 * #1 12 #2 10 #3 31 #4 11 #5 1 #6 43 #7 2 #8 11 #9 34 #10 8
 */
