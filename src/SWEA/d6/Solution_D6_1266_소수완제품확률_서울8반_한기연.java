package com.d6;

import java.io.*;
import java.util.*;

public class Solution_D6_1266_소수완제품확률_서울8반_한기연 {
	public static int[] primeNums = { 2, 3, 5, 7, 11, 13, 17 };

	public static double nCr(int n, int r) {
		if (r == 0)
			return 1.0;
		return 1.0 * n / r * nCr(n - 1, r - 1);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D6_1266_소수완제품확률.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			double masterA = Integer.parseInt(st.nextToken()) / 100.0;
			double masterB = Integer.parseInt(st.nextToken()) / 100.0;

			double A = 0.0;
			double B = 0.0;
			for (int i = 0; i < primeNums.length; i++) {
				A += nCr(18, primeNums[i])
						* (Math.pow(masterA, primeNums[i]) * Math.pow(1 - masterA, 18 - primeNums[i]));
				B += nCr(18, primeNums[i])
						* (Math.pow(masterB, primeNums[i]) * Math.pow(1 - masterB, 18 - primeNums[i]));
			}

			double result = 1 - (1 - A) * (1 - B);

			System.out.print("#" + tc + " ");
			System.out.printf("%.6f\n", result);
		}
	}
}
