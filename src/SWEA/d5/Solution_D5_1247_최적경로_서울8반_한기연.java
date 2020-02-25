package com.d5;

import java.io.*;
import java.util.*;

public class Solution_D5_1247_최적경로_서울8반_한기연 {
	public static Point office, home;
	public static Point[] customer;
	public static int N, result;

	public static class Point {
		public int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int dis(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	public static void swap(int a, int b) {
		Point tmp = customer[a];
		customer[a] = customer[b];
		customer[b] = tmp;
	}

	public static void perm(int k) {
		if (k == N) {
			int tmp = dis(office, customer[0]);
			for (int i = 1; i < N; i++)
				tmp += dis(customer[i - 1], customer[i]);
			tmp += dis(customer[N - 1], home);
			result = (result < tmp) ? result : tmp;
			return;
		}
		for (int i = k; i < N; i++) {
			swap(k, i);
			perm(k + 1);
			swap(k, i);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D5_1247_최적경로.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			customer = new Point[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			office = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < N; i++)
				customer[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			result = Integer.MAX_VALUE;

			perm(0);

			System.out.println("#" + tc + " " + result);
		}
		br.close();
	}
}
