package com.d1;

import java.io.*;
import java.util.*;

public class Solution_D1_2070_큰놈작은놈같은놈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D1_2070_큰놈작은놈같은놈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == b)
				System.out.println("#" + tc + " " + "=");
			else if (a > b)
				System.out.println("#" + tc + " " + ">");
			else
				System.out.println("#" + tc + " " + "<");
		}

		br.close();
	}
}
