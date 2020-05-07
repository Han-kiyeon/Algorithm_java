package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Silver1_7569_토마토.java
 *
 * @Date : 2020. 5. 7.
 * @작성자 : 한기연
 * @메모리 : 293700 kb
 * @실행시간 : 1424 ms
 *
 * @Blog : __
 **/

public class Silver1_7569_토마토 {
	static int N, M, H;
	static int[][][] map;

	static int[][] dir = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 0, -1, 0 }, { 0, 1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		map = new int[H][N][M];
		Queue<int[]> q = new LinkedList<>();

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 1은 익은 토마토, 0 은 익지 않은 토마토, -1은 빈 칸
					map[k][i][j] = sc.nextInt();
					if (map[k][i][j] == 1)
						q.add(new int[] { k, i, j });
				}
			}
		}
		int ans = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			ans++;
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();
				for (int k = 0; k < dir.length; k++) {
					int nh = now[0] + dir[k][0];
					int nr = now[1] + dir[k][1];
					int nc = now[2] + dir[k][2];
					if (isRange(nh, nr, nc) && map[nh][nr][nc] == 0) {
						map[nh][nr][nc] = 1;
						q.add(new int[] { nh, nr, nc });
					}
				}
			}
		}
		boolean flag = true;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[k][i][j] == 0) {
						flag = false;
						break;
					}
				}
			}
		}
		System.out.println(flag ? ans : -1);

	}

	private static boolean isRange(int nh, int nr, int nc) {
		if (0 <= nh && nh < H && 0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}