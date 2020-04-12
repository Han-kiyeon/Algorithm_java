import java.util.Scanner;

public class Main {
	static int N;
	static int[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < N; j++) {
					if (k == j || i == j)
						continue;
					if (graph[i][j] == graph[i][k] + graph[k][j])
						graph[i][j] = 0;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				ans += graph[i][j];
			}
		}
		System.out.println(ans);

	}
}