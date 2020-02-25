package com.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기_서울8반_한기연 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2805_D3_농작물수확하기.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < N; j++)
					farm[i][j] = tmp.charAt(j) - '0';
			}
//			for (int[] c : farm)
//				System.out.println(Arrays.toString(c));
//			System.out.println();

			for (int i = 0; i < N; i++) {// 행
				for (int j = 0; j < N; j++) {// 열
					if (i <= N / 2) {
						if (Math.abs(N / 2 - i) >= j + 1)
							farm[i][j] = 0;
						else if (Math.abs(N / 2 - i) >= N - j)
							farm[i][j] = 0;
					} else {
						if (Math.abs(N / 2 - i) >= j + 1)
							farm[i][j] = 0;
						else if (Math.abs(N / 2 - i) >= N - j)
							farm[i][j] = 0;
					}
				}
			}

			int sum = 0;
			for (int i = 0; i < N; i++) {// 행
				for (int j = 0; j < N; j++) {// 열
					sum += farm[i][j];
				}
			}

			//for (int[] c : farm)
			//	System.out.println(Arrays.toString(c));
			
			System.out.println("#"+tc+" "+sum);

		}
		sc.close();
	}

}
