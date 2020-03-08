package BOJ.DFS_BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gold4_2206_벽부수고이동하기 {
	static int N, M, ans;
	static char[][] map;

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		ans = -1;
		BFS();
		System.out.println(ans);
	}

	private static void BFS() {
		boolean visit[][][] = new boolean[2][N][M];

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0, 1 });
		visit[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[0] == N - 1 && now[1] == M - 1) {
				ans = now[3];
				break;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = now[0] + dr[dir];
				int nc = now[1] + dc[dir];
				if (isRange(nr, nc) && !visit[now[2]][nr][nc]) {
					if (map[nr][nc] == '0') {
						visit[now[2]][nr][nc] = true;
						q.offer(new int[] { nr, nc, now[2], now[3] + 1 });
					} else if (now[2] == 0) {
						visit[1][nr][nc] = true;
						q.offer(new int[] { nr, nc, 1, now[3] + 1 });
					}
				}
			}
		}
	}

	private static boolean isRange(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < M)
			return true;
		return false;
	}
}
