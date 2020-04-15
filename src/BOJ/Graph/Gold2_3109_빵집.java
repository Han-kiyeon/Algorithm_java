package BOJ.Graph;
import java.util.Scanner;

public class Gold2_3109_빵집 {
	static int N, M, ans;
	static char[][] map;
	static boolean[][] visit;

	static int[] dr = { -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		ans = 0;
		for (int i = 0; i < N; i++) {
			ans += DFS(i, 0);
		}
		System.out.println(ans);
	}

	private static int DFS(int i, int j) {
		visit[i][j] = true;

		if (j == M - 1)
			return 1;

		for (int k = 0; k < 3; k++) {
			int nr = i + dr[k];
			int nc = j + 1;

			if (isRange(nr, nc) && !visit[nr][nc] && map[nr][nc] == '.') {
				int v = DFS(nr, nc);
				if (v != 0)
					return v;
			}
		}
		return 0;
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}