package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1218_괄호짝짓기_한기연_ver1 {

	public static int N;
	public static char[] tcArr;

	public static boolean solve(int start, int end) {
		if ((end - start) == 1)
			if ((tcArr[start] == '(' && tcArr[end] == ')') || (tcArr[start] == '<' && tcArr[end] == '>')
					|| (tcArr[start] == '[' && tcArr[end] == ']') || (tcArr[start] == '{' && tcArr[end] == '}'))
				return true;
			else
				return false;

		int middle = -1;
		int cnt = 1;
		
		switch (tcArr[start]) {
			case '{':
				for (int i = start + 1; i <= end; i++) {
					if (tcArr[i] == '{') {
						cnt++;
					} else if (tcArr[i] == '}') {
						cnt--;
						if (cnt == 0) {
							middle = i;
							break;
						}
					}
				}
				break;
	
			case '[':
				for (int i = start + 1; i <= end; i++) {
					if (tcArr[i] == '[') {
						cnt++;
					} else if (tcArr[i] == ']') {
						cnt--;
						if (cnt == 0) {
							middle = i;
							break;
						}
					}
				}
				break;
	
			case '<':
				for (int i = start + 1; i <= end; i++) {
					if (tcArr[i] == '<') {
						cnt++;
					} else if (tcArr[i] == '>') {
						cnt--;
						if (cnt == 0) {
							middle = i;
							break;
						}
					}
				}
				break;
	
			case '(':
				for (int i = start + 1; i <= end; i++) {
					if (tcArr[i] == '(') {
						cnt++;
					} else if (tcArr[i] == ')') {
						cnt--;
						if (cnt == 0) {
							middle = i;
							break;
						}
					}
				}
				break;
	
			default:
				break;
		}

		if (middle == -1)
			return false;

		if (end != middle) {
			return solve(start + 1, middle - 1) && solve(middle + 1, end);
		} else if (middle - 1 == start)
			return solve(middle + 1, end);
		else
			return solve(start + 1, end - 1);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1218_D4_괄호짝짓기.txt"));
		Scanner s = new Scanner(System.in);

		int T = 10; // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			N = s.nextInt();// 테스트 케이스의 길이
			tcArr = s.next().toCharArray();

			int ans;
			if (solve(0, N - 1))
				ans = 1;
			else
				ans = 0;
			System.out.println("#" + tc + " " + ans);
		}

		s.close(); // Scanner close
	}
}
