package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver3_14889_스타트와링크.java
 *
 * @Date : 2020. 2. 7.
 * @작성자 : 한기연
 * @메모리 : 15556 kb
 * @실행시간 : 328 ms
 *
 * @Blog : __
 **/

public class Silver3_14889_스타트와링크 {
	static int N, half, ans;
	static int[][] data;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		data = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				data[i][j] = sc.nextInt();
			}
		}
		ans = Integer.MAX_VALUE;
		half = N >> 1;
		visit = new boolean[N];
		solve(0, 0);
		System.out.println(ans);
	}

	private static void solve(int index, int depth) {
		if (depth == half) {
			check();
			return;
		}
		for (int i = index; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				solve(i, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static void check() {
		int tmp1 = 0, tmp2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i] == visit[j]) {
					if (visit[i])
						tmp1 += data[i][j];
					else
						tmp2 += data[i][j];
				}
			}
		}
		int rlt = Math.abs(tmp1 - tmp2);

		if (ans > rlt)
			ans = rlt;
	}
}