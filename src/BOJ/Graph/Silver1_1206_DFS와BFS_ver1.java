package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Graph
 * @FileName : Silver1_1206_DFS와BFS.java
 *
 * @Date : 2019. 9. 6.
 * @작성자 : 한기연
 * @메모리 : 23464 kb
 * @실행시간 : 264 ms
 *
 * @Blog : __
 **/

public class Silver1_1206_DFS와BFS_ver1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) + 1;
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int[][] graph = new int[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		boolean[] visit = new boolean[N];
		DFS(graph, N, visit, V);
		System.out.println();
		visit = new boolean[N];
		BFS(graph, N, visit, V);
		System.out.println();
	}

	private static void BFS(int[][] graph, int n, boolean[] visit, int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		visit[v] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int i = 0; i < n; i++)
				if (graph[cur][i] == 1)
					if (!visit[i]) {
						visit[i] = true;
						q.offer(i);
					}
		}
	}

	private static void DFS(int[][] graph, int n, boolean[] visit, int v) {
		System.out.print(v + " ");
		visit[v] = true;
		for (int i = 0; i < n; i++)
			if (graph[v][i] == 1)
				if (!visit[i])
					DFS(graph, n, visit, i);

	}
}