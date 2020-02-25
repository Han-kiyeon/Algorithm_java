package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1233_사칙연산유효성검사_한기연2 {
	static String[][] arr;
	static int N;
	static int ans = 1;

	private static boolean checkOp(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1233_D4_사칙연산유효성검사.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10; // 10개의 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 정점의 개수
			arr = new String[N + 1][4];
			ans = 1;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = st.nextToken(); // 정점번호
				arr[i][1] = st.nextToken(); // 값 or 연산자
				if (st.hasMoreTokens())
					arr[i][2] = st.nextToken();// 왼쪽 노드
				if (st.hasMoreTokens())
					arr[i][3] = st.nextToken();// 오른쪽 노드
				
				if(!checkOp(arr[i][1]))//숫자
					if(arr[i][2]!=null||arr[i][3]!=null)
						ans = 0;
			}

//			for (String[] s : arr) {
//				System.out.println(Arrays.toString(s));
//			}

	
			 System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
}
