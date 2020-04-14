import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static char[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static boolean[] key;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt() + 2;
			M = sc.nextInt() + 2;

			map = new char[N][M];

			for (int i = 0; i < N; i++) {
				Arrays.fill(map[i], '.');
			}

			for (int i = 1; i < N - 1; i++) {
				String str = sc.next();
				for (int j = 1; j < M - 1; j++) {
					map[i][j] = str.charAt(j - 1);
				}
			}

			String init_key = sc.next();
			key = new boolean[26];

			for (int i = 0; i < init_key.length(); i++) {
				if (init_key.charAt(i) == '0')
					break;
				key[init_key.charAt(i) - 'a'] = true;
			}

			int ans = 0;
			visit = new boolean[N][M];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { 0, 0 });
			visit[0][0] = true;

			while (!q.isEmpty()) {
				int[] now = q.poll();
				for (int k = 0; k < dr.length; k++) {
					int nr = now[0] + dr[k];
					int nc = now[1] + dc[k];
					if (!isRange(nr, nc) || map[nr][nc] == '*' || visit[nr][nc])
						continue;
					// 문서일경우
					if (map[nr][nc] == '$') {
						ans++;
						map[nr][nc] = '.';
					}
					// 문일 경우
					else if ('A' <= map[nr][nc] && map[nr][nc] <= 'Z') {
						if (!key[map[nr][nc] - 'A'])
							continue;
						map[nr][nc] = '.';
					}
					// 열쇠일 경우
					else if ('a' <= map[nr][nc] && map[nr][nc] <= 'z') {
						key[map[nr][nc] - 'a'] = true;
						map[nr][nc] = '.';
						q.clear();
						for (int i = 0; i < N; i++) {
							Arrays.fill(visit[i], false);
						}
					}
					visit[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}

			} // end of while
			System.out.println(ans);
		} // end of TC
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}