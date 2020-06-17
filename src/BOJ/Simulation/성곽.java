package BOJ.Simulation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//5:00
public class 성곽 {
	static int H, W, n, max;
	static int[][] input;

	static int[][] map;
	static boolean[][] visit;

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	static int[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();

		input = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		map = new int[H][W];
		visit = new boolean[H][W];
		n = 0;
		max = 0;
		ArrayList<Integer> cnt = new ArrayList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (visit[i][j])
					continue;
				int tmp = BFS(i, j, n);
				cnt.add(tmp);
				if (max < tmp)
					max = tmp;
				n++;
			}
		}


		graph = new int[n][n];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				for (int k = 0; k < dr.length; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (isRange(nr, nc) && map[i][j] != map[nr][nc]) {
						int now = map[i][j];
						int next = map[nr][nc];
						graph[now][next] = graph[next][now] = cnt.get(now) + cnt.get(next);
					}
				}
			}
		}

		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (ret < graph[i][j])
					ret = graph[i][j];
			}
		}
		System.out.println(n);
		System.out.println(max);
		System.out.println(ret);
	}

	private static int BFS(int i, int j, int num) {
		int ret = 0;
		Queue<int[]> q = new LinkedList<>();

		visit[i][j] = true;
		q.add(new int[] { i, j });

		while (!q.isEmpty()) {
			ret++;
			int[] now = q.poll();
			map[now[0]][now[1]] = num;
			for (int k = 0; k < dr.length; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];
				if (!isRange(nr, nc) || visit[nr][nc])
					continue;

				if (go(k, input[now[0]][now[1]])) {
					visit[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
		return ret;
	}

	private static boolean go(int k, int i) {
		return (i & (1 << k)) == 0;
	}

	private static boolean isRange(int r, int c) {
		return 0 <= r && r < H && 0 <= c && c < W;
	}
}