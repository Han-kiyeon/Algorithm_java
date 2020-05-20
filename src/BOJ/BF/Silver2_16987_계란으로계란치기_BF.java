package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver2_계란으로계란치기_BF.java
 *
 * @Date : 2020. 5. 21.
 * @작성자 : 한기연
 * @메모리 : 280476 kb
 * @실행시간 : 812 ms
 *
 * @Blog : __
 **/
public class Silver2_16987_계란으로계란치기_BF {
	static int N, ans;
	static int[][] data;
	static int[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		data = new int[N][2];
		for (int i = 0; i < N; i++) {
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
		}

		ans = 0;
		list = new int[N];
		solve(0);
		System.out.println(ans);
	}

	private static void solve(int depth) {
		if (depth == N) {
			int ret = calc();
			if (ans < ret)
				ans = ret;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (depth == i)
				continue;
			list[depth] = i;
			solve(depth + 1);
		}
	}

	private static int calc() {
		int[] tmp = new int[N];
		for (int i = 0; i < N; i++) {
			tmp[i] = data[i][0]; // 내구도
		}
		for (int k = 0; k < N; k++) {
			if (tmp[k] <= 0 || tmp[list[k]] <= 0) // 손에 든 계란이 깨짐
				continue; // 턴을 넘긴다.
			if (tmp[k] > 0 && tmp[list[k]] > 0) {
				tmp[k] -= data[list[k]][1];
				tmp[list[k]] -= data[k][1];
			}
		}
		int cnt = 0;
		for (int i : tmp) {
			if (i <= 0)
				cnt++;
		}
		return cnt;
	}
}