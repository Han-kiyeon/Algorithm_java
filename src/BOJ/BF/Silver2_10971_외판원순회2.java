package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver2_10971_외판원순회2.java
 *
 * @Date : 2020. 1. 26.
 * @작성자 : 한기연
 * @메모리 : 16024 kb
 * @실행시간 : 404 ms
 **/

public class Silver2_10971_외판원순회2 {
	static int N, ret;
	static boolean[] visit;
	static int[][] map;
	static int[] perm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		perm = new int[N];
		visit = new boolean[N];
		ret = Integer.MAX_VALUE;
		solve(0);
		System.out.println(ret);
	}

	private static void solve(int depth) {
		if (depth == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				if (map[perm[i]][perm[i + 1]] == 0)
					return;
				sum += map[perm[i]][perm[i + 1]];
			}
			if (map[perm[N - 1]][perm[0]] == 0)
				return;
			sum += map[perm[N - 1]][perm[0]];
			if (ret > sum)
				ret = sum;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				perm[depth] = i;
				solve(depth + 1);
				visit[i] = false;
			}
		}
	}
}