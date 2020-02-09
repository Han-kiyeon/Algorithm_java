import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int ans;
	static int[][][][] map = new int[5][4][5][5];
	static int[] sol_visit = new int[5];
	// 상, 하 ,좌 ,우, 아래로,
	static int[] dr = { -1, 1, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0 };
	static int[] dz = { 0, 0, 0, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					map[k][0][i][j] = sc.nextInt();
					rotate(k);
				}
			}
		}

		ans = Integer.MAX_VALUE;
		solve(0);

		if (ans != Integer.MAX_VALUE)
			System.out.println(ans);
		else
			System.out.println(-1);
	}

	private static void rotate(int k) {
		for (int x = 1; x < 4; x++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					map[k][x][j][4 - i] = map[k][x - 1][i][j];
				}
			}
		}
	}

	private static void solve(int depth) {
		if (depth == 5) {
			// System.out.println(Arrays.toString(visit));
			check();
			return;
		}
		for (int i = 0; i < 4; i++) {
			sol_visit[depth] = i;
			solve(depth + 1);
		}
	}

	private static void check() {
		// 입구나 출구가 없을때
		if (map[0][sol_visit[0]][0][0] != 1 && map[4][sol_visit[0]][4][4] == 1)
			return;

		boolean[][][] visit = new boolean[5][5][5];
		Queue<int[]> q = new LinkedList<>();

		visit[0][0][0] = true;
		q.offer(new int[] { 0, 0, 0, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			// 이미 최소값보다 클때
			if (cur[3] >= ans)
				continue;
			// 출구에 도착했을때
			if (cur[0] == 4 && cur[1] == 4 && cur[2] == 4) {
				if (ans > cur[3])
					ans = cur[3];
				return;
			}
			for (int dir = 0; dir < 5; dir++) {
				int nz = cur[0] + dz[dir];
				int nr = cur[1] + dr[dir];
				int nc = cur[2] + dc[dir];
				if (isrange(nz, nr, nc) && !visit[nz][nr][nc] && map[nz][sol_visit[nz]][nr][nc] == 1) {
					visit[nz][nr][nc] = true;
					q.offer(new int[] { nz, nr, nc, cur[3] + 1 });
				}
			}
		}

	}

	private static boolean isrange(int z, int r, int c) {
		if ((0 <= z && z < 5) && (0 <= r && r < 5) && (0 <= c && c < 5))
			return true;
		return false;
	}
}