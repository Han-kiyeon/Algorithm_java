package com.d3;

import java.io.*;
import java.util.*;

public class Solution_D3_1244_최대상금_한기연 {
	public static int[] data;
	public static int N, result;

	public static void solve(int cur, int cnt) {
		if (cnt == N) {
			int tmp = 0, digit = 1;
			for (int i = data.length - 1; i >= 0; i--) {
				tmp += data[i] * digit;
				digit *= 10;
			}
			result = (result > tmp) ? result : tmp;
			return;
		}
		
		for (int i = cur; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
					swap(i, j);
					solve(i, cnt + 1);
					swap(i, j);
				
			}
		}

//		for (int i = cur; i < data.length; i++) {
//			if (data[cur] <= data[i]) {
//				swap(cur, i);
//				// System.out.println((cnt+1)+": ("+i+", "+j+")"+Arrays.toString(data));
//				solve(i, cnt + 1);
//				swap(cur, i);
//			}
//		}
	}

	public static void swap(int a, int b) {
		int tmp = data[a];
		data[a] = data[b];
		data[b] = tmp;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D3_1244_최대상금.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			N = Integer.parseInt(st.nextToken());

			data = new int[str.length()];

			for (int i = 0; i < data.length; i++) {
				data[i] = str.charAt(i) - '0';
			}
			// System.out.println(N+ ">>>"+Arrays.toString(data));
			result = 0;
			solve(0, 0);
			System.out.println("#" + tc + " " + result);
		}

		br.close();
	}

}
