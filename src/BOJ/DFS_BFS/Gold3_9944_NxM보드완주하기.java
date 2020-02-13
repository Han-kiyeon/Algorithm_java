package BOJ.DFS_BFS;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold3_9944_NxM보드완주하기.java
 *
 * @Date : 2020. 2. 13.
 * @작성자 : 한기연
 * @메모리 : 20148 kb
 * @실행시간 : 356 ms
 *
 * @Blog : __
 **/
public class Gold3_9944_NxM보드완주하기 {
	static int N, M, ans;
	static int[][] map;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int TC = 0;
		while (sc.hasNext()) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			int blank = -1; // 빈 칸의 개수
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					if (str.charAt(j) == '*')
						map[i][j] = 1;
					else {
						map[i][j] = 0;
						blank++;
					}
				}
			}

			ans = 123456789;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						DFS(i, j, 0, blank);
						map[i][j] = 0;
					}
				}
			}
			if (ans == 123456789)
				ans = -1;
			System.out.println("Case " + ++TC + ": " + ans);
		}
	}

	private static void DFS(int i, int j, int cnt, int blank) {
		if (blank == 0 && ans > cnt) {
			ans = cnt;
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nr = i + dr[dir];
			int nc = j + dc[dir];
			if (isRange(nr, nc) && map[nr][nc] == 0) {
				while (isRange(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					blank--;
					nr += dr[dir];
					nc += dc[dir];
				}
				nr -= dr[dir];
				nc -= dc[dir];
				DFS(nr, nc, cnt + 1, blank);

				while (nr != i || nc != j) {
					map[nr][nc] = 0;
					blank++;
					nr -= dr[dir];
					nc -= dc[dir];
				}
			}

		}
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}