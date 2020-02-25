package com.d2;

import java.io.*;
import java.util.*;

public class Solution_D2_1954_달팽이숫자 {

	public static int N;

	// --------------------------------- 우, 하, 좌, 상
	public static int[] di = new int[] { 0, 1, 0, -1 };
	public static int[] dj = new int[] { 1, 0, -1, 0 };

	public static boolean Range(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < N)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1954_D2_달팽이숫자.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			
			N = Integer.parseInt(br.readLine());
			int[][] matrix = new int[N][N];

			int x = 0, y = 0, dir = 0, cnt = 1;
			for (int i = 0; i < N * N; i++) {
				matrix[x][y] = cnt++;

				int ni = x + di[dir];
				int nj = y + dj[dir];

				if (!Range(ni, nj) || matrix[ni][nj] != 0) {
					dir = (++dir) % 4;
					ni = x + di[dir];
					nj = y + dj[dir];
				}

				x = ni;
				y = nj;
			}

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
			
			
		}
		br.close();
	}
}
