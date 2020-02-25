package com.d3;

import java.util.*;
import java.io.*;

public class Solution_D3_6958_동철이의프로그래밍대회_한기연 {
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/D3_6958_동철이의프로그래밍대회.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			// long start = System.currentTimeMillis();
			System.out.print("#" + test_case + " ");
			////////////////////// 입 력 //////////////////////
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

			int N = Integer.parseInt(st.nextToken()); // N 명
			int M = Integer.parseInt(st.nextToken()); // M 개

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < M; j++) {
					if (Integer.parseInt(st.nextToken()) == 1)
						arr[i]++;
				}
			}
			// System.out.println(Arrays.toString(matrix));
			int max = -1;

			for (int x : arr)
				max = (max > x) ? max : x;

			int cnt = 0;
			for (int x : arr)
				if (max == x)
					cnt++;

			System.out.println(cnt + " " + max);
			// System.out.println("시간: " + (System.currentTimeMillis() - start) + " ns");
		} // end of test_case
		br.close(); // BufferedReader close
	}// end of main
}