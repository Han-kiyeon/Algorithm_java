import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C;
	static char[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] visit;

	static Point[] swan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];

		swan = new Point[2];
		int index = 0;
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'L') {
					map[i][j] = '.';
					swan[index++] = new Point(i, j);
				}
			}
		}

		int ans = 0;
		while (true) {
			ans++;
			visit = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '.' && visit[i][j] == 0)
						BFS(i, j);
				}
			}
			if (meet())
				break;
		}
		System.out.println(ans);

	}

	private static boolean meet() {
		visit = new int[R][C];
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { swan[0].x, swan[0].y });
		visit[swan[0].x][swan[0].y] = 1;

		while (!q.isEmpty()) {
			int now[] = q.poll();
			if (now[0] == swan[1].x && now[1] == swan[1].y)
				return true;

			for (int k = 0; k < dc.length; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];
				if (isRange(nr, nc) && visit[nr][nc] == 0 && map[nr][nc] == '.') {
					visit[nr][nc] = 1;
					q.add(new int[] { nr, nc });
				}
			}
		}
		return false;
	}

	private static void BFS(int x, int y) {
		visit[x][y] = -1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int k = 0; k < dr.length; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];

				if (!isRange(nr, nc))
					continue;
				if (visit[nr][nc] == 0 && map[nr][nc] == '.') {
					visit[nr][nc] = -1;
					q.add(new int[] { nr, nc });
				} else if (map[nr][nc] == 'X')
					visit[nr][nc]++;
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (visit[i][j] > 0)
						map[i][j] = '.';
				}
			}

		}

	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < R && 0 <= nc && nc < C)
			return true;
		return false;
	}
}