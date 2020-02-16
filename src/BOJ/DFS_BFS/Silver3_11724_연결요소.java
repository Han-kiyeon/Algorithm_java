package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Silver3_11724_연결요소.java
 *
 * @Date : 2020. 2. 16.
 * @작성자 : 한기연
 * @메모리 : 283,972 kb
 * @실행시간 : 1,352 ms
 *
 * @Blog : __
 **/
public class Silver3_11724_연결요소 {
	static int N, M, ans;
	static boolean[][] graph;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		graph = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			graph[s][e] = true;
			graph[e][s] = true;
		}
		ans = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				BFS(i);
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static void BFS(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visit[x] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (!visit[i] && graph[cur][i]) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}

	}
}