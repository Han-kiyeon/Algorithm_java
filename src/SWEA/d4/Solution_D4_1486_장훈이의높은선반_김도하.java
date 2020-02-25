package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1486_장훈이의높은선반_김도하 {
	static int data[];
	static int R, N, result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D4_1486_장훈이의높은선반.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
		
			st = new StringTokenizer(br.readLine());
			data = new int[N];
			for (int i = 0; i < N; i++)
				data[i] = Integer.parseInt(st.nextToken());
			
			result = Integer.MAX_VALUE;
			dfs(0, 0);
			
			System.out.println("#" + tc + " " + (result-R));
		}
	}

	static void dfs(int v, int len) {
		if (len >= R) {
			result = (result > len) ? len : result;
			return;
		}
		
		if (v == N)
			return;
		
		dfs(v + 1, len + data[v]);
		dfs(v + 1, len);
	}
}