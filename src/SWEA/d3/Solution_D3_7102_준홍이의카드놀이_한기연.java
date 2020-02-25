package com.d3;

import java.util.*;
import java.io.*;

public class Solution_D3_7102_준홍이의카드놀이_한기연 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/D3_7102_준홍이의카드놀이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] arr = new int[N + M + 1];
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= M; j++)
					arr[i + j]++;

			int max = Integer.MIN_VALUE;
			for (int i = 2; i <= N + M; i++)
				max = (max > arr[i]) ? max : arr[i];

			System.out.print("#" + tc);
			for (int i = 2; i <= N + M; i++)
				if (arr[i] == max)
					System.out.print(" " + i);
			System.out.println();
		}

	}
}
