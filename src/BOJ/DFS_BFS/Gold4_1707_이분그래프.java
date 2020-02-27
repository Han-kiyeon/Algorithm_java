package BOJ.DFS_BFS;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold4_1707_이분그래프.java
 *
 * @Date : 2020. 2. 27.
 * @작성자 : 한기연
 * @메모리 : 314196 kb
 * @실행시간 : 2804 ms
 *
 * @Blog : __
 **/

public class Gold4_1707_이분그래프 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		for (int tc = 0; tc < K; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			LinkedList<Integer>[] graph = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				graph[i] = new LinkedList<>();
			}
			for (int i = 0; i < E; i++) {
				int s = sc.nextInt() - 1;
				int e = sc.nextInt() - 1;
				graph[s].add(e);
				graph[e].add(s);
			}

			boolean flag = true;
			int[] visit = new int[V];
			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < V; i++) {
				if (visit[i] == 0) {
					q.offer(i);
					visit[i] = 1;

					while (!q.isEmpty() && flag) {
						int cur = q.poll();
						for (Integer next : graph[cur]) {
							if (visit[next] == 0) {
								q.offer(next);
								visit[next] = visit[cur] * -1;
							} else if (visit[next] == visit[cur]) {
								flag = false;
								break;
							}
						}
					}

				}
			}
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}