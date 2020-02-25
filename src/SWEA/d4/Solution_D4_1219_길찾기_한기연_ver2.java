package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1219_길찾기_한기연_ver2 {
	public static int N, cnt = 1;
	public static int[][] arr;

	public static boolean solve(int start) {
		int flag = start;
		Stack<Integer> stack = new Stack<>();

		while (true) {
			if (arr[0][flag] != 0)
				stack.push(arr[0][flag]);
			if (arr[1][flag] != 0)
				stack.push(arr[1][flag]);
			
			flag=stack.pop();
			if(flag==99)
				return true;
			if(stack.empty())
				return false;		
		}
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
