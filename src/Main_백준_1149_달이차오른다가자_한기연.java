import java.util.Scanner;

public class Main_백준_1149_달이차오른다가자_한기연 {
	static int N, M, ans;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		int si = -1, sj = -1;
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
		sc.close();

		ans = Integer.MAX_VALUE;
		int[][][] visit = new int[1 << 6][N][M];
		visit[0][si][sj] = 1;
		DFS(si, sj, 1, 0, visit);

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

	private static void DFS(int i, int j, int cnt, int key, int[][][] visit) {
		visit[key][i][j] = cnt;

		// System.out.printf("%6s \n",Integer.toBinaryString(key));
		/*
		 * for (int k = 0; k < N; k++) { for (int k2 = 0; k2 < M; k2++) {
		 * System.out.print(visit[key][k][k2] + " "); } System.out.println(); }
		 * System.out.println();
		 */
		if (ans < cnt)
			return;

		for (int dir = 0; dir < 4; dir++) {
			int r = i + dr[dir];
			int c = j + dc[dir];
			if (isRange(r, c)) {
				// 빈곳
				if (map[r][c] == '.' && visit[key][r][c] == 0) {
					// visit[key][r][c] = cnt + 1;
					DFS(r, c, cnt + 1, key, visit); // 이동

				}
				// 벽
				else if (map[r][c] == '#') {
					continue;
				}
				// 열쇠
				else if ('a' <= map[r][c] && map[r][c] <= 'z' && visit[key][r][c] == 0) {
					if ((key & (1 << (map[r][c] - 'a'))) == 0) {
						// 키를 얻는다
						int newkey = key | (1 << (map[r][c] - 'a'));
						// visit[newkey][r][c] = cnt + 1;
						DFS(r, c, cnt + 1, newkey, visit); // 이동
					} else {
						// visit[key][r][c] = cnt + 1;
						DFS(r, c, cnt + 1, key, visit); // 이동
					}

				}
				// 문
				else if ('A' <= map[r][c] && map[r][c] <= 'Z' && visit[key][r][c] == 0) {
					// 키가 있으면
					if ((key & (1 << (map[r][c] - 'A'))) > 0) {
						// visit[key][r][c] = cnt + 1;
						DFS(r, c, cnt + 1, key, visit); // 이동
					}
				}
				// 출구
				else if (map[r][c] == '1' && visit[key][r][c] == 0) {
					// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					if (ans > cnt)
						ans = cnt;
					return;
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
