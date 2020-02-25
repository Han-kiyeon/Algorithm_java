package com.d4;

import java.util.*;
import java.io.*;

public class Solution_D4_2819_격자판의숫자이어붙이기_서울8반_한기연 {
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int[][] matrix;
	private static Set<Integer> set;

	private static boolean range(int x, int y) {
		if (0 <= x && x < 4 && 0 <= y && y < 4)
			return true;
		return false;
	}

	private static void sol(int x, int y, int cnt, int num) {
		if (cnt == 7) {
			set.add(num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ni = x + dx[i];
			int nj = y + dy[i];
			if (range(ni, nj)) 
				sol(ni, nj, cnt + 1, num*10+matrix[ni][nj]);
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/D4_2819_격자판의숫자이어붙이기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			matrix = new int[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					matrix[i][j] = Integer.parseInt(st.nextToken());
			}

			set = new HashSet<>();
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) 
					sol(i, j, 1, matrix[i][j]);

			System.out.println("#" + tc + " " + set.size());
		}

	}
}
