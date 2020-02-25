package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1486_장훈이의높은선반_한기연 {
	public static int N, B, result;
	public static int[] high;

	public static void sol() {
		int i, j;
		for (i = 0; i < (1 << N); ++i) {
			int sum = 0;
			for (j = N - 1; j >= 0; --j) {
				// System.out.print(((i >> j) & 1));
				if (((i >> j) & 1) == 1)
					sum += high[j];
			}
			// System.out.println();
			if (sum >= B)
				result = (result > sum) ? sum : result;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D4_1486_장훈이의높은선반.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// N, B(1 ≤ N ≤ 20, 1 ≤ B ≤ S)
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			high = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				high[i] = Integer.parseInt(st.nextToken());

			result = Integer.MAX_VALUE;
			sol();

			System.out.println("#" + tc + " " + (result - B));
		}
		br.close();
	}
}