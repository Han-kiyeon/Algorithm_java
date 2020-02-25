package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_3289_서로소집합_서울8반_한기연 {
	public static LinkedList<String> list;
	public static int N;

	public static void hap(int a, int b) {
		int ai = -1, bi = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains("" + a))
				ai = i;
			if (list.get(i).contains("" + b))
				bi = i;
		}
		if (ai != bi) {
			String tmp = list.get(ai) + " " + list.get(bi);
			list.add(tmp);
			if (bi > ai) {
				list.remove(bi);
				list.remove(ai);
			} else {
				list.remove(ai);
				list.remove(bi);
			}
		}
		//System.out.println(list);
	}

	public static void same(int a, int b) {

		int ai = -1, bi = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains("" + a))
				ai = i;
			if (list.get(i).contains("" + b))
				bi = i;
		}
		if (ai != bi) {
			System.out.print(0);
		} else
			System.out.print(1);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D4_3289_서로소집합.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			list = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				list.add("" + i);
			}
			//System.out.println(list);

			System.out.print("#" + tc + " ");

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				switch (op) {
				case 0: // 합집합 연산
					hap(a, b);
					break;

				case 1: // 같은 집합 확인
					same(a, b);
					break;
				}
			}
			System.out.println();
		}
		br.close();
	}
}
