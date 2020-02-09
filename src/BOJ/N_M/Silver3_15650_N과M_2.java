package BOJ.N_M;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.N_M
 * @FileName : Silver3_15650_N과M_2.java
 *
 * @Date : 2020. 2. 9.
 * @작성자 : 한기연
 * @메모리 : 14312 kb
 * @실행시간 : 116 ms
 *
 * @Blog : __
 **/

public class Silver3_15650_N과M_2 {
	static int N, M;
	static int[] rlt;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N];
		rlt = new int[M];
		solve(0, 0);
	}

	private static void solve(int index, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(rlt[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = index; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				rlt[depth] = i + 1;
				solve(i, depth + 1);
				visit[i] = false;
			}
		}
	}
}