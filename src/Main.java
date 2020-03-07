import java.util.Scanner;

public class Main {
	static int N, M, ans;
	static int r, c, dir;
	static int[][] map;
	// 0북, 1동, 2남, 3서
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		r = sc.nextInt();
		c = sc.nextInt();
		dir = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		ans = 0;
		solve();
		System.out.println(ans);
	}

	private static void solve() {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			ans++;
		} else if (map[r][c] == 1) {
			return;
		}

		for (int k = 0; k < 4; k++) {
			dir = dir == 0 ? 3 : dir - 1;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 모든외곽은 벽이므로 범위 체크 안함.
			if (map[nr][nc] == 0) {
				r = nr;
				c = nc;
				solve();
				return;
			}
		}
		r -= dr[dir];
		c -= dc[dir];
		solve();
	}
}