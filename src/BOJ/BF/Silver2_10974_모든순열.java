package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver2_10974_모든순열.java
 *
 * @Date : 2020. 1. 25.
 * @작성자 : 한기연
 * @메모리 : 73692 kb
 * @실행시간 : 1016 ms
 **/

public class Silver2_10974_모든순열 {
	static int N;
	static int[] data;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		data = new int[N];
		visit = new boolean[N];
		solve(0, 0);
	}

	private static void solve(int idx, int depth) {
		if (depth == N) {
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				data[depth] = i + 1;
				solve(i, depth + 1);
				visit[i] = false;
			}
		}

	}
}