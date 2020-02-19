package BOJ.DFS_BFS;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold5_1261_알고스팟.java
 *
 * @Date : 2020. 2. 19.
 * @작성자 : 한기연
 * @메모리 : 24700 kb
 * @실행시간 : 352 ms
 *
 * @Blog : __
 **/

public class Gold5_1261_알고스팟 {

	static int N, M, ans;
	static boolean[][] map, visit;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == '1')
					map[i][j] = true;
			}
		}
		ans = 1234567890;
		BFS(0, 0);
		System.out.println(ans);
	}

	private static void BFS(int i, int j) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] x, int[] y) -> x[2] >= y[2] ? 1 : -1);
		visit = new boolean[M][N];
		visit[i][j] = true;
		pq.offer(new int[] { i, j, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (cur[0] == M - 1 && cur[1] == N - 1) {
				ans = cur[2];
			}

			for (int dir = 0; dir < dc.length; dir++) {
				int r = cur[0] + dr[dir];
				int c = cur[1] + dc[dir];

				if (isRange(r, c) && !visit[r][c]) {
					visit[r][c] = true;
					if (map[r][c])
						pq.offer(new int[] { r, c, cur[2] + 1 });
					else
						pq.offer(new int[] { r, c, cur[2] });
				}
			}
		}
	}

	private static boolean isRange(int r, int c) {
		if (0 <= r && r < M && 0 <= c && c < N)
			return true;
		return false;
	}
}