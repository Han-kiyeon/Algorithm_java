package com.d3;

import java.util.*;
import java.io.*;

public class Solution_D3_6730_장애물경주난이도_한기연 {
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/D3_6730_장애물경주난이도.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			long start = System.currentTimeMillis();
			System.out.print("#" + test_case + " ");
			////////////////////// 입 력 //////////////////////
			int N = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			System.out.println(Arrays.toString(arr));

			int up = 0, down = 0;

			for (int i = 0; i < N - 1; i++) {
				down = (down > (arr[i] - arr[i + 1])) ? down : arr[i] - arr[i + 1];
				up = (up > (arr[i+1] - arr[i])) ? up : arr[i+1] - arr[i];
			}

			///////////////////////////////////////////////////

			System.out.println(up+" "+down);
			//System.out.println("시간: " + (System.currentTimeMillis() - start) + " ns");
		} // end of test_case
		br.close(); // BufferedReader close
	}// end of main
}