package BOJ.DFS_BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gold5_17836_공주님을구해라 {
	static int N, M, T, ans;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		boolean[][][] visit = new boolean[2][N][M];
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 0, 0, 0, 0 });
		visit[0][0][0] = true;

		while (!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			int sword = q.peek()[2];
			int time = q.peek()[3];
			q.poll();

			if (r == N - 1 && c == M - 1) {
				ans = time;
				break;
			}
			if (time == T) {
				continue;
			}
			for (int dir = 0; dir < dc.length; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (!isRange(nr, nc))
					continue;
				if (sword == 0 && map[nr][nc] == 1)
					continue;

				if (!visit[sword][nr][nc]) {
					if (map[nr][nc] == 2) {
						visit[1][nr][nc] = true;
						q.add(new int[] { nr, nc, 1, time + 1 });
					} else {
						visit[sword][nr][nc] = true;
						q.add(new int[] { nr, nc, sword, time + 1 });
					}
				}

			}
		}

		System.out.println(ans == 0 ? "Fail" : ans);
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}