package BOJ.DFS_BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold3_1938_통나무옮기기.java
 *
 * @Date : 2020. 5. 2.
 * @작성자 : 한기연
 * @메모리 : 14952 kb
 * @실행시간 : 136 ms
 *
 * @Blog : __
 **/
public class Gold3_1938_통나무옮기기 {
	static int N;
	static char[][] map;
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static class Tree {
		int r, c;
		int dir; // 0이면 세로 1이면 가로

		public Tree(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	static Tree start, end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'B') {
					if (isRange(i - 1, j) && map[i - 1][j] == 'B' && isRange(i + 1, j) && map[i - 1][j] == 'B') {
						start = new Tree(i, j, 0);
						map[i][j] = map[i - 1][j] = map[i + 1][j] = '0';
					} else if (isRange(i, j - 1) && map[i][j - 1] == 'B' && isRange(i, j + 1) && map[i][j + 1] == 'B') {
						start = new Tree(i, j, 1);
						map[i][j] = map[i][j - 1] = map[i][j + 1] = '0';
					}
				} else if (map[i][j] == 'E') {
					if (isRange(i - 1, j) && map[i - 1][j] == 'E' && isRange(i + 1, j) && map[i - 1][j] == 'E') {
						end = new Tree(i, j, 0);
						map[i][j] = map[i - 1][j] = map[i + 1][j] = '0';

					} else if (isRange(i, j - 1) && map[i][j - 1] == 'E' && isRange(i, j + 1) && map[i][j + 1] == 'E') {
						end = new Tree(i, j, 1);
						map[i][j] = map[i][j - 1] = map[i][j + 1] = '0';
					}
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visit = new boolean[N][N][2];

		q.add(new int[] { start.r, start.c, start.dir, 0 });
		visit[start.r][start.c][start.dir] = true;

		while (!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			int dir = q.peek()[2];
			int time = q.peek()[3];
			q.poll();
			if (r == end.r && c == end.c && dir == end.dir) {
				System.out.println(time);
				System.exit(0);
			}
			if (dir == 0) { // 세로
				// U
				if (isRange(r - 2, c) && !visit[r - 1][c][dir] && map[r - 2][c] == '0') {
					q.add(new int[] { r - 1, c, dir, time + 1 });
					visit[r - 1][c][dir] = true;
				}
				// D
				if (isRange(r + 2, c) && !visit[r + 1][c][dir] && map[r + 2][c] == '0') {
					q.add(new int[] { r + 1, c, dir, time + 1 });
					visit[r + 1][c][dir] = true;

				}
				// L
				if (isRange(r, c - 1) && !visit[r][c - 1][dir] && map[r][c - 1] == '0' && map[r - 1][c - 1] == '0'
						&& map[r + 1][c - 1] == '0') {
					q.add(new int[] { r, c - 1, dir, time + 1 });
					visit[r][c - 1][dir] = true;

				}
				// R
				if (isRange(r, c + 1) && !visit[r][c + 1][dir] && map[r][c + 1] == '0' && map[r - 1][c + 1] == '0'
						&& map[r + 1][c + 1] == '0') {
					q.add(new int[] { r, c + 1, dir, time + 1 });
					visit[r][c + 1][dir] = true;

				}
			} else { // 가로
				// U
				if (isRange(r - 1, c) && !visit[r - 1][c][dir] && map[r - 1][c] == '0' && map[r - 1][c - 1] == '0'
						&& map[r - 1][c + 1] == '0') {
					q.add(new int[] { r - 1, c, dir, time + 1 });
					visit[r - 1][c][dir] = true;

				}
				// D
				if (isRange(r + 1, c) && !visit[r + 1][c][dir] && map[r + 1][c] == '0' && map[r + 1][c - 1] == '0'
						&& map[r + 1][c + 1] == '0') {
					q.add(new int[] { r + 1, c, dir, time + 1 });
					visit[r + 1][c][dir] = true;

				}
				// L
				if (isRange(r, c - 2) && !visit[r][c - 1][dir] && map[r][c - 2] == '0') {
					q.add(new int[] { r, c - 1, dir, time + 1 });
					visit[r][c - 1][dir] = true;

				}
				// R
				if (isRange(r, c + 2) && !visit[r][c + 1][dir] && map[r][c + 2] == '0') {
					q.add(new int[] { r, c + 1, dir, time + 1 });
					visit[r][c + 1][dir] = true;
				}
			}

			boolean flag = true;
			for (int k = 0; k < dr.length; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (!isRange(nr, nc) || map[nr][nc] != '0') {
					flag = false;
					break;
				}
			}
			if (flag) {
				if (dir == 0)
					dir = 1;
				else
					dir = 0;
				if (!visit[r][c][dir]) {
					q.add(new int[] { r, c, dir, time + 1 });
					visit[r][c][dir] = true;
				}
			}
		}
		System.out.println(0);
	}

	private static boolean isRange(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < N)
			return true;
		return false;
	}
}