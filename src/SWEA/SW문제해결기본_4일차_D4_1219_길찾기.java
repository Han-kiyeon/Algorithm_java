package SWEA;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_4일차_D4_1219_길찾기.java
 *
 * @Date : 2019. 7. 24.
 * @작성자 : 한기연
 * @메모리 : 36,812 kb
 * @실행시간 : 170 ms
 *
 * @Blog : __
 **/
class SW문제해결기본_4일차_D4_1219_길찾기 {
	static int T, N, ans;
	static ArrayList<Integer>[] list;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			T = sc.nextInt();
			N = sc.nextInt();
			ans = 0;
			list = new ArrayList[100];
			for (int i = 0; i < 100; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 1; i <= N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list[a].add(b);
			}
			dfs(0);
			System.out.println("#" + tc + " " + ans);

		}
	}

	static void dfs(int v) {
		if (v == 99) {
			ans = 1;
			return;
		}
		for (int i = 0; i < list[v].size(); i++) {
			if (list[v].get(i) != 0) {
				dfs(list[v].get(i));
			}
		}

	}
}