package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1494_사랑의카운슬러_서울8반_한기연 {
	static int N;
	static boolean visit;
	static ArrayList<Point> list;

	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static long dis(Point p1, Point p2) {
		return ((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y));
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D4_1494_사랑의카운슬러.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				list.add(new Point(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			//System.out.println(list);
			
			solve();

		} // end of tc
	}// end of main

	 static void solve() {
		
	}
}
