package BOJ.DFS_BFS;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gold4_2638_치즈 {
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
		boolean flag = true;
		while (flag) {
			flag = false;
			ans++;
			Queue<int[]> q = new LinkedList<>();
			int[][] visit = new int[N][M];
			visit[0][0] = -1;
			q.add(new int[] { 0, 0 });
			while (!q.isEmpty()) {
				int[] now = q.poll();
				for (int k = 0; k < dr.length; k++) {
					int nr = now[0] + dr[k];
					int nc = now[1] + dc[k];
					if (!isRange(nr, nc))
						continue;
					if (map[nr][nc] == 0 && visit[nr][nc] == 0) {
						q.add(new int[] { nr, nc });
						visit[nr][nc] = -1;
					} else if (map[nr][nc] == 1) {
						visit[nr][nc]++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visit[i][j] >= 2) {
						map[i][j]--;
						flag = true;
					}
				}
			}
		}
		System.out.println(ans - 1);
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}