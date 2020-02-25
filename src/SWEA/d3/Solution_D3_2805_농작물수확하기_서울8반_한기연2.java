package com.d3;

import java.io.*;

public class Solution_D3_2805_농작물수확하기_서울8반_한기연2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2805_D3_농작물수확하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(N);
			int M = N / 2;
			System.out.println(M);
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++)
					if (Math.abs(M - i) + Math.abs(M - j) <= M)
						sum += s.charAt(j) - '0';
			}
			bw.write("#" + tc + " " + String.valueOf(sum) + "\n");
		}
		bw.flush();
	}
}