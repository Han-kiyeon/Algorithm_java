package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold2_1175_배달.java
 *
 * @Date : 2020. 3. 22.
 * @작성자 : 한기연
 * @메모리 : 20068 kb
 * @실행시간 : 168__ ms
 *
 * @Blog : __
 **/
public class Gold2_1175_배달 {
	static int N, M;
	static char[][] map;
	static int[][] point;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		point = new int[3][2];
		int idx = 1;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					point[0][0] = i;
					point[0][1] = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'C') {
					point[idx][0] = i;
					point[idx++][1] = j;
					map[i][j] = '.';
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();
		// visit[r][c][status][dir]
		boolean[][][][] visit = new boolean[N][M][3][4];

		for (int i = 0; i < 4; i++) {
			visit[point[0][0]][point[0][1]][0][i] = true;
		}

		q.offer(new int[] { point[0][0], point[0][1], -1, 0, 0 });
		while (!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			int dir = q.peek()[2];
			int cnt = q.peek()[3];
			int status = q.peek()[4];
			q.poll();

			if (r == point[1][0] && c == point[1][1]) { // 1번 도착
				status |= 1;
			} else if (r == point[2][0] && c == point[2][1]) { // 2번 도착
				status |= 2;
			}

			if (status == 3) {
				System.out.println(cnt);
				System.exit(0);
			}

			for (int k = 0; k < dr.length; k++) {
				if (k == dir)
					continue;
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (isRange(nr, nc) && !visit[nr][nc][status][k] && map[nr][nc] == '.') {
					visit[nr][nc][status][k] = true;
					q.offer(new int[] { nr, nc, k, cnt + 1, status });
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}