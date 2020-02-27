package BOJ.DFS_BFS;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Silver1_2178_미로탐색.java
 *
 * @Date : 2020. 2. 27.
 * @작성자 : 한기연
 * @메모리 : 19064 kb
 * @실행시간 : 152 ms
 *
 * @Blog : __
 **/
public class Silver1_2178_미로탐색 {
	static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		char[][] maze = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j);
			}
		}
		int[][] visit = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		visit[0][0] = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int dir = 0; dir < dr.length; dir++) {
				int r = cur[0] + dr[dir];
				int c = cur[1] + dc[dir];
				if (isRange(r, c) && visit[r][c] == 0 && maze[r][c] == '1') {
					q.offer(new int[] { r, c });
					visit[r][c] = visit[cur[0]][cur[1]] + 1;
				}
			}
		}
		System.out.println(visit[N - 1][M - 1]);
	}

	private static boolean isRange(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < M)
			return true;
		return false;
	}
}