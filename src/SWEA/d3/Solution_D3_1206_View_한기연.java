package com.d3;

import java.util.*;
import java.io.*;

public class Solution_D3_1206_View_한기연 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/1206_D3_View.txt"));
		Scanner s = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int N = s.nextInt();
			int[] ba = new int[N]; // BuildingArr

			for (int i = 0; i < N; i++)
				ba[i] = s.nextInt();

			int cnt = 0;

			for (int i = 2; i < N - 2; i++) {
				for (int j = 1; j < ba[i] + 1; j++) {
					if ((ba[i - 2] < j) && (ba[i - 1] < j) && (ba[i + 1] < j) && (ba[i + 2] < j))
						cnt++;
				}
			}
			System.out.println("#" + (tc + 1) + " " + cnt);
		}

		s.close(); // Scanner close
	}
}
