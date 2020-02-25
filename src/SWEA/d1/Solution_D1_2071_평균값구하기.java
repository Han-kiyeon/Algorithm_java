package com.d1;

import java.io.*;
import java.util.*;

public class Solution_D1_2071_평균값구하기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D1_2072_홀수만더하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp % 2 != 0)
					sum += tmp;
			}
			System.out.println("#" + tc + " " + sum);
		}

		br.close();
	}
}
