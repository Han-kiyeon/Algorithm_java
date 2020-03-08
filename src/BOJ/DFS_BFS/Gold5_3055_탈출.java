package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold5_3055_탈출.java
 *
 * @Date : 2020. 3. 8.
 * @작성자 : 한기연
 * @메모리 : 14624 kb
 * @실행시간 : 120 ms
 *
 * @Blog : __
 **/
public class Gold5_3055_탈출 {
	static int R, C, ans;
	static char[][] map;

	static Queue<int[]> me, water;
	static int[] end;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		me = new LinkedList<>();
		water = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					me.add(new int[] { i, j, 0 });
					map[i][j] = '.';
				} else if (map[i][j] == 'D') {
					end = new int[] { i, j };
				} else if (map[i][j] == '*') {
					water.add(new int[] { i, j });
				}
			}
		}
		ans = -1;
		BFS();
		System.out.println(ans == -1 ? "KAKTUS" : ans);

	}

	private static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[R][C];

		visit[me.peek()[0]][me.peek()[1]] = true;

		while (!me.isEmpty() || !water.isEmpty()) {
			while (!water.isEmpty()) {
				q.offer(water.poll());
			}

			while (!q.isEmpty()) {
				// 물의 움직임
				int[] now = q.poll();
				for (int dir = 0; dir < dr.length; dir++) {
					int nr = now[0] + dr[dir];
					int nc = now[1] + dc[dir];
					if (isRange(nr, nc) && (map[nr][nc] == '.')) {
						water.add(new int[] { nr, nc });
						map[nr][nc] = '*';
					}
				}
			}

			while (!me.isEmpty()) {
				q.offer(me.poll());
			}

			while (!q.isEmpty()) {
				// 비버의 움직임
				int[] now = q.poll();
				if (now[0] == end[0] && now[1] == end[1]) {
					ans = now[2];
					return;
				}
				for (int dir = 0; dir < dr.length; dir++) {
					int nr = now[0] + dr[dir];
					int nc = now[1] + dc[dir];
					if (isRange(nr, nc) && !visit[nr][nc])
						if (map[nr][nc] == '.' || map[nr][nc] == 'D') {
							me.add(new int[] { nr, nc, now[2] + 1 });
							visit[nr][nc] = true;
						}
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