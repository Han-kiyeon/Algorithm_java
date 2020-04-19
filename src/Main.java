import java.util.Scanner;

public class Main {
	static int N, M;
	static boolean[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		graph = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;
			graph[s][e] = true;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < N; j++) {
					if (k == j || i == j || graph[i][j])
						continue;
					if (graph[i][k] && graph[k][j])
						graph[i][j] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (!graph[i][j] && !graph[j][i])
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}
}