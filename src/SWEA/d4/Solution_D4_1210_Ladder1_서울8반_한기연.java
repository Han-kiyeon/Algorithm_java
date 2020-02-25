package com.d4;

import java.util.*;
import java.io.*;

public class Solution_D4_1210_Ladder1_서울8반_한기연{
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
