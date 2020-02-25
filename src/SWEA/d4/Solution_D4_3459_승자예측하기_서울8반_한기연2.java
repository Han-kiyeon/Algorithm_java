package com.d4;

import java.util.*;
import java.io.*;

public class Solution_D4_3459_승자예측하기_서울8반_한기연2 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/D4_3459_승자예측하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			long N = Long.parseLong(br.readLine());
			long x = 1;
			boolean flag = false;
			long answer = 1;
			while (answer < N) {
				if (!flag)
					x *= 4;
				answer += x;
				flag = !flag;
			}
			System.out.println((flag) ? "Alice" : "Bob");
		} // end of TC
	}// end of main
}
