package com.d4;

import java.util.*;
import java.io.*;

public class Solution_D4_4408_자기방으로돌아가기_서울8반_한기연 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D4_4408_자기방으로돌아가기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int[] cor = new int[201]; // 복도 길이. 0번은 안씀.
			int N = Integer.parseInt(br.readLine());

			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				start = (start + 1) / 2;
				end = (end + 1) / 2;

				if (start < end)
					for (int i = start; i <= end; i++)
						cor[i]++;
				else
					for (int i = end; i <= start; i++)
						cor[i]++;

			}
			int max = Integer.MIN_VALUE;
			for (int i = 1; i <= 200; i++)
				if (max < cor[i])
					max = cor[i];

			System.out.println("#" + tc + " " + max);
		}
	}

}


