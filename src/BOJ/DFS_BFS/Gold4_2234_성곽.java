package BOJ.DFS_BFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gold4_2234_성곽 {
	static int N, M;
	static int[][] map, input;

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		input = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		int idx = 1;

		map = new int[N][M];
		int max = -1;
		ArrayList<Integer> size = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					int ret = BFS(i, j, idx++);
					size.add(ret);
					if (max < ret)
						max = ret;
				}
			}
		}

		System.out.println(size.size());
		System.out.println(max);

		int[][] graph = new int[size.size()][size.size()];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int dir = 0; dir < dc.length; dir++) {
					int nr = i + dr[dir];
					int nc = j + dc[dir];

					if (!isRange(nr, nc))
						continue;

					if (map[i][j] != map[nr][nc]) {
						int s = map[i][j] - 1;
						int e = map[nr][nc] - 1;
						graph[s][e] = graph[e][s] = 1;
					}
				}
			}
		}

		int ans = -1;
		for (int i = 0; i < graph.length; i++) {
			for (int j = i + 1; j < graph.length; j++) {
				if (graph[i][j] == 1) {
					int tmp = size.get(i) + size.get(j);
					if (ans < tmp)
						ans = tmp;
				}
			}
		}
		System.out.println(ans);

//		for (int[] is : graph) {
//			System.out.println(Arrays.toString(is));
//		}
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
	}

	private static int BFS(int i, int j, int k) {
		int ret = 1;
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { i, j });
		map[i][j] = k;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int dir = 0; dir < dr.length; dir++) {
				int nr = now[0] + dr[dir];
				int nc = now[1] + dc[dir];

				if (!isRange(nr, nc) || map[nr][nc] != 0)
					continue;
				if ((input[now[0]][now[1]] & (1 << dir)) == 0) {
					map[nr][nc] = k;
					ret++;
					q.add(new int[] { nr, nc });
				}
			}
		}

		return ret;
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}