package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold4_2573_빙산.java
 *
 * @Date : 2020. 4. 8.
 * @작성자 : 한기연
 * @메모리 : 255480 kb
 * @실행시간 : 1092 ms
 *
 * @Blog : __
 **/
public class Gold4_2573_빙산 {
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		while (true) {
			ans++;

			int[][] mel = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0) {
						int m = 0;
						for (int k = 0; k < dr.length; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							if (isRange(nr, nc) && map[nr][nc] == 0)
								m++;
						}
						mel[i][j] = m;
					}
				}
			}

			Queue<int[]> q = new LinkedList<>();
			boolean[][] visit = new boolean[N][M];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] -= mel[i][j];
					if (map[i][j] < 0)
						map[i][j] = 0;
					else if (map[i][j] > 0) {
						count++;
						if (q.isEmpty()) {
							q.offer(new int[] { i, j });
							visit[i][j] = true;
						}
					}
				}
			}
			if (count == 0) {
				System.out.println(0);
				return;
			}
			int size = 1;
			while (!q.isEmpty()) {
				int[] now = q.poll();
				for (int k = 0; k < dr.length; k++) {
					int nr = now[0] + dr[k];
					int nc = now[1] + dc[k];
					if (isRange(nr, nc) && map[nr][nc] > 0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.offer(new int[] { nr, nc });
						size++;
					}
				}
			}

			if (size != count) {
				System.out.println(ans);
				return;
			}
		}
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}