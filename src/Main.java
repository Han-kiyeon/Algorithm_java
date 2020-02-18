import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, ans;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visit = new boolean[1 << 6][N][M];
		int si = 0, sj = 0;

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (str.charAt(j) == '0') {
					si = i;
					sj = j;
					map[i][j] = '.';
				}
			}
		}

		ans = 1234567890;
		BFS(si, sj);

		if (ans == 1234567890)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

	private static void BFS(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		visit[0][y][x] = true;

		q.offer(new int[] { 0, y, x, 0 });

		while (!q.isEmpty()) {
			int key = q.peek()[0];
			int i = q.peek()[1];
			int j = q.peek()[2];
			int cnt = q.peek()[3];
			q.poll();

			if (map[i][j] == '1' && ans > cnt) {
				ans = cnt;
			}

			for (int dir = 0; dir < 4; dir++) {
				int r = i + dr[dir];
				int c = j + dc[dir];
				if (isRange(r, c) && !visit[key][r][c] && map[r][c] != '#') {
					// 빈곳 || 출구
					if (map[r][c] == '.' || map[r][c] == '1') {
						visit[key][r][c] = true;
						q.offer(new int[] { key, r, c, cnt + 1 }); // 이동
					}
					// 열쇠
					else if ('a' <= map[r][c] && map[r][c] <= 'f' && !visit[key][r][c]) {
						//System.out.println("get:" + map[r][c]);
						int nkey = key | (1 << (map[r][c] - 'a')); // 키를 얻고
						visit[key][r][c] = true;
						q.offer(new int[] { nkey, r, c, cnt + 1 }); // 이동
					}
					// 문
					else if ('A' <= map[r][c] && map[r][c] <= 'F' && !visit[key][r][c]) {
						// 키가 있으면
						if ((key & (1 << (map[r][c] - 'A'))) > 0) {
							//System.out.println(" open:" + map[r][c]);
							visit[key][r][c] = true;
							q.offer(new int[] { key, r, c, cnt + 1 }); // 이동
						}
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