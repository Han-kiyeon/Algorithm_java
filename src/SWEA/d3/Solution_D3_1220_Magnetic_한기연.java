package com.d3;

import java.io.*;
import java.util.*;

public class Solution_D3_1220_Magnetic_한기연 {

	static int[][] matric;
	static int cnt;
	static int N;


	static void check(int x, int y) {
		for (int i = x + 1; i < N; i++) {
			if (matric[i][y] == 1)
				return;
			if (matric[i][y] == 2) {
				cnt++;
				return;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1220_D3_magnetic.txt"));

		Scanner s = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			N = s.nextInt();
			matric = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matric[i][j] = s.nextInt();
				}
			}

			cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matric[i][j] == 1) {
						check(i, j);
					}
				}
			}

			System.out.println("#" + tc + " " + cnt);
		}
		
		s.close();

	}

}