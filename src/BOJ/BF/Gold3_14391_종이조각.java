package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold3_14391_종이조각.java
 *
 * @Date : 2020. 3. 14.
 * @작성자 : 한기연
 * @메모리 : 17152 kb
 * @실행시간 : 160 ms
 *
 * @Blog : __
 **/
public class Gold3_14391_종이조각 {
	static int N, M, ans;
	static int[] map;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N * M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i * M + j] = str.charAt(j) - '0';
			}
		}

		visit = new boolean[N * M];
		ans = 0;
		solve(0);
		System.out.println(ans);
	}

	private static void solve(int idx) {
		if (idx == N * M) {
			check();
			return;
		}

		// 해당 좌표 선택(가로 선택)
		visit[idx] = true;
		solve(idx + 1);

		// 해당 좌표미선택(세로 선택)
		visit[idx] = false;
		solve(idx + 1);

	}

	private static void check() {
		int sum = 0, tmp = 0;

		// 가로
		for (int i = 0; i < N; i++) {
			tmp = 0;
			for (int j = 0; j < M; j++) {
				if (visit[i * M + j]) {
					tmp *= 10;
					tmp += map[i * M + j];
				} else {
					sum += tmp;
					tmp = 0;
				}
			}
			sum += tmp;
		}

		// 세로
		for (int j = 0; j < M; j++) {
			tmp = 0;
			for (int i = 0; i < N; i++) {
				if (!visit[i * M + j]) {
					tmp *= 10;
					tmp += map[i * M + j];
				} else {
					sum += tmp;
					tmp = 0;
				}
			}
			sum += tmp;
		}

		// 최대값 갱신
		ans = Math.max(ans, sum);
	}
}
