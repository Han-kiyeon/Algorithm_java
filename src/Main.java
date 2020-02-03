import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//시간초과
class Main {
	static int N, M, ans;
	static int[][] graph;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new int[N][N];
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			graph[s][e] = 1;
			graph[e][s] = 1;
		}
		ans = 0;
		for (int i = 0; i < N; i++) {

			BFS(i);
		}
		System.out.println(ans);
	}

	private static void BFS(int i) {
		visit = new boolean[N];
		visit[i] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, 1 });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			visit[tmp[0]] = true;

			if (tmp[1] == 5) {
				ans = 1;
				return;
			}

			for (int j = 0; j < N; j++) {
				if (graph[tmp[0]][j] == 1 && !visit[j]) {
					q.offer(new int[] { j, tmp[1] + 1 });
				}
			}
		}

	}

}
