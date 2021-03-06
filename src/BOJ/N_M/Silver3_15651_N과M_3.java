package BOJ.N_M;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.N_M
 * @FileName : Silver3_15651_N과M_3.java
 *
 * @Date : 2020. 2. 16.
 * @작성자 : 한기연
 * @메모리 : 373,692 kb
 * @실행시간 : 696 ms
 *
 * @Blog : __
 **/

public class Silver3_15651_N과M_3 {
	static int N, M;
	static int[] rlt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		rlt = new int[M];
		solve(0, 0);
		System.out.println(sb);
	}

	private static void solve(int index, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(rlt[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			rlt[depth] = i + 1;
			solve(i, depth + 1);
		}

	}
}