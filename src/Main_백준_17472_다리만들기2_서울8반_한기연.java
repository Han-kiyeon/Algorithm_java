import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_17472_다리만들기2_서울8반_한기연 {
	static int N, M, count;
	static int[][] map;
	static int[][] graph;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int tmp = sc.nextInt();
				if (tmp == 1)
					map[i][j] = -1;
				else
					map[i][j] = tmp;
			}
		}

		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1)
					BFS(i, j, ++count);
			}
		}

		graph = new int[count][count];
		
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				if (i == j)
					continue;
				graph[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] != 0) {
					for (int dir = 0; dir < 4; dir++) {
						int r = i + dr[dir];
						int c = j + dc[dir];
						if (range(r, c)) {
							if (map[r][c] == 0) {
								makeGraph(new int[] { i, j }, new int[] { r, c }, dir, 1);
							}
						}
					}
				}
			}
		}

		dist = new int[count];
		System.out.println(prim(graph));

	}

	public static int prim(int[][] graph) {
		Arrays.fill(dist, -1);
		dist[0] = 0;

		for (int k = 0; k < count; k++) {
			int minWeight = Integer.MAX_VALUE;
			int minVertex = 0;

			for (int i = 0; i < count; i++) {
				if (dist[i] < 0)
					continue;
				for (int j = 0; j < count; j++) {
					if (dist[j] >= 0)
						continue;
					if (minWeight > graph[i][j]) {
						minWeight = graph[i][j];
						minVertex = j;
					}
				}
			}
			dist[minVertex] = minWeight;

		}
		int sum = 0;
		for (int i = 1; i < count; i++) {
			if(dist[i]==-1)
				return -1;
			sum += dist[i];
		}
		return sum;
	}

	private static void makeGraph(int[] start, int[] cur, int dir, int cnt) {
		int r = cur[0] + dr[dir];
		int c = cur[1] + dc[dir];
		if (range(r, c)) {
			if (map[r][c] == 0) {
				makeGraph(start, new int[] { r, c }, dir, ++cnt);
			} else {
				int s = map[start[0]][start[1]] - 1;
				int e = map[r][c] - 1;
				if (cnt >= 2) {
					if (graph[s][e] > cnt) {
						graph[s][e] = cnt;
						graph[e][s] = cnt;
					}
				}
			}
		}
	}

	private static void BFS(int i, int j, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { i, j, cnt });
		map[i][j] = cnt;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int k = 0; k < 4; k++) {
				int r = tmp[0] + dr[k];
				int c = tmp[1] + dc[k];
				if (range(r, c)) {
					if (map[r][c] == -1) {
						q.offer(new int[] { r, c, cnt });
						map[r][c] = cnt;
					}
				}
			}
		}
	}
	private static boolean range(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < M)
			return true;
		return false;
	}
}
