package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver2_10819_차이를최대로.java
 *
 * @Date : 2020. 1. 26.
 * @작성자 : 한기연
 * @메모리 : 15168 kb
 * @실행시간 : 128 ms
 **/

public class Silver2_10819_차이를최대로 {
	static int N, ret;
	static boolean[] visit;
	static int[] data, perm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		data = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}

		perm = new int[N];
		visit = new boolean[N];
		ret = 0;
		solve(0);
		System.out.println(ret);
	}

	private static void solve(int depth) {
		if (depth == N) {
			int sum = 0;
			// System.out.println(Arrays.toString(combi));
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(perm[i] - perm[i + 1]);
			}
			if (ret < sum)
				ret = sum;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				perm[depth] = data[i];
				solve(depth + 1);
				visit[i] = false;
			}
		}
	}
}