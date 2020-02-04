package BOJ.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Graph
 * @FileName : Silver1_1206_DFS와BFS_ver2.java
 *
 * @Date : 2020. 2. 4.
 * @작성자 : 한기연
 * @메모리 : 39384 kb
 * @실행시간 : 452 ms
 *
 * @Blog : __
 **/

public class Silver1_1206_DFS와BFS_ver2 {
	static int N, M, V;
	static int[][] graph;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt() + 1;
		M = sc.nextInt();
		V = sc.nextInt();
		graph = new int[N][N];
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			graph[s][e] = 1;
			graph[e][s] = 1;
		}
		visit = new boolean[N];
		DFS(V);
		System.out.println();
		visit = new boolean[N];
		BFS(V);
		System.out.println();

	}

	private static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		visit[v] = true;
		q.offer(v);

		while (!q.isEmpty()) {
			int i = q.poll();
			System.out.print(i + " ");
			for (int j = 1; j < N; j++) {
				if (!visit[j] && graph[i][j] == 1) {
					visit[j] = true;
					q.offer(j);
				}
			}
		}

	}

	private static void DFS(int i) {
		visit[i] = true;
		System.out.print(i + " ");
		for (int j = 1; j < N; j++) {
			if (!visit[j] && graph[i][j] == 1) {
				DFS(j);
			}
		}

	}
}