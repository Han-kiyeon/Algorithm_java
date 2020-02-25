package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1219_길찾기_한기연 {
	public static int N, cnt = 1;
	public static int[][] arr;

	public static boolean solve(int start) {
		if (arr[0][start] == 99 || arr[1][start] == 99)
			return true;

		if (arr[0][start] != 0 && arr[1][start] != 0) {
			return solve(arr[0][start]) || solve(arr[1][start]);
		} else if (arr[0][start] != 0) {
			return solve(arr[0][start]);
		} else if (arr[1][start] != 0) {
			return solve(arr[0][start]);
		} else
			return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1219_D4_길찾기.txt"));
		Scanner s = new Scanner(System.in);
		// A(0)->B(99)로 가는길 찾기
		int T = 10; // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			s.nextInt(); // 테스트 케이스 번호

			N = s.nextInt(); // 길의 총 개수
			arr = new int[2][100];

			for (int i = 0; i < N; i++) {
				int start = s.nextInt();
				int end = s.nextInt();
				if (arr[0][start] == 0)
					arr[0][start] = end;
				else
					arr[1][start] = end;
			}
			
			for(int[] a :arr)System.out.println(Arrays.toString(a));
			int result;
			if (solve(0))
				result = 1;
			else
				result = 0;

			System.out.println("#" + tc + " " + result);
		}

		s.close(); // Scanner close
	}
}
