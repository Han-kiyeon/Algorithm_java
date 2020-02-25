package com.d4;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_1251_하나로_prim_서울8반_한기연 {
	public static int N;
	public static long INF = Long.MAX_VALUE;
	public static double[] w;

	public static long prim(double[][] a) {
		Arrays.fill(w, -1);
		w[0] = 0;
		for (int k = 1; k < N; k++) {
			double minWeight = INF;
			int minVertex = 0;

			for (int i = 0; i < N; i++) {
				if (w[i] < 0)
					continue;
				for (int j = 0; j < N; j++) {
					if (w[j] >= 0)
						continue;
					if (minWeight > a[i][j]) {
						minWeight = a[i][j];
						minVertex = j;
					}
				}
			}
			w[minVertex] = minWeight;
		}
		double sum = 0;
		for (int i = 1; i < N; i++)
			sum += w[i];

		return (long) (Math.round(sum));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			w = new double[N];
			double[] x = new double[N];
			double[] y = new double[N];
			double[][] a = new double[N][N];
			for (int i = 0; i < N; i++)
				x[i] = sc.nextInt();

			for (int i = 0; i < N; i++)
				y[i] = sc.nextInt();
			double chk = sc.nextDouble();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					a[i][j] = (Math.abs(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2)) * chk);
					a[j][i] = a[i][j];
				}
			}
			System.out.println("#" + tc + " " + prim(a));
		}
		sc.close();
	}
}
