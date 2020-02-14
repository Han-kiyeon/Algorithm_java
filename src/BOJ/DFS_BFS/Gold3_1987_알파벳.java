package BOJ.DFS_BFS;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold3_1987_알파벳.java
 *
 * @Date : 2020. 2. 14.
 * @작성자 : 한기연
 * @메모리 : 15,140 kb
 * @실행시간 : 940 ms
 *
 * @Blog : https://herong.tistory.com/entry/BOJ-1987-%EC%95%8C%ED%8C%8C%EB%B2%B3-BFS-Java
 **/

public class Gold3_1987_알파벳 {
	static int R, C, ans;
	static char[][] map;
	static boolean[] visit = new boolean[26];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		ans = 0;
		visit[map[0][0] - 'A'] = true;
		DFS(0, 0, 1);
		System.out.println(ans);
	}

	private static void DFS(int i, int j, int cnt) {
		if (ans < cnt)
			ans = cnt;
		else if (ans == 26)
			return;
		for (int dir = 0; dir < dr.length; dir++) {
			int nr = i + dr[dir];
			int nc = j + dc[dir];

			if (isRange(nr, nc) && !visit[map[nr][nc] - 'A']) {
				visit[map[nr][nc] - 'A'] = true;
				DFS(nr, nc, cnt + 1);
				visit[map[nr][nc] - 'A'] = false;
			}
		}

	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < R && 0 <= nc && nc < C)
			return true;
		return false;
	}
}
