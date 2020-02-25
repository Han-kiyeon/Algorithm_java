package com.d4;

import java.util.*;
import java.io.*;

public class Solution_D4_1258_행렬찾기_서울8반_한기연 {
	static int N;
	public static int[][] matrix;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { -1, 1, 0, 0 };

	static boolean range(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N)
			return true;
		return false;
	}

	static int[] solve(int x, int y) {
		int selo = x;
		int galo = y;
		while (range(++selo, galo) && matrix[selo][galo] != 0);
		selo--;
		while (range(selo, ++galo) && matrix[selo][galo] != 0);
		galo--;

		for (int i = x; i <= selo; i++)
			for (int j = y; j <= galo; j++) {
				matrix[i][j] = 0;
			}
		int[] res = { selo - x + 1, galo - y + 1 };

		return res;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/D4_1258_행렬찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = Integer.parseInt(br.readLine().trim());
			matrix = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ArrayList<int[]> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] != 0)
						list.add(solve(i, j));
				}
			}
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if((o1[0] * o1[1]) == (o2[0] * o2[1]))
						return o1[0]-o2[0];
					else
						return (o1[0] * o1[1]) -(o2[0] * o2[1]);
				}
			});
			System.out.print(list.size() + " ");
			for (int[] x : list)
				System.out.print(x[0] + " " + x[1] + " ");
			System.out.println();

		} // end of tc
	}// end of main
}
