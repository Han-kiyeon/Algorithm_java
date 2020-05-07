package BOJ.DFS_BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Silver2_2664_촌수계산.java
 *
 * @Date : 2020. 5. 7.
 * @작성자 : 한기연
 * @메모리 : 14396 kb
 * @실행시간 : 112 ms
 *
 * @Blog : __
 **/
public class Silver2_2664_촌수계산 {
	static int N;
	static boolean[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int start = sc.nextInt() - 1;
		int end = sc.nextInt() - 1;

		graph = new boolean[N][N];
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;
			graph[s][e] = graph[e][s] = true;
		}
		System.out.println(BFS(start, end));
	}

	private static int BFS(int start, int end) {
		boolean[] visit = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		q.add(start);

		int ans = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int now = q.poll();
				if (now == end)
					return ans;
				for (int i = 0; i < N; i++) {
					if (graph[now][i] && !visit[i]) {
						visit[i] = true;
						q.add(i);
					}
				}
			}
			ans++;
		}
		return -1;
	}
}