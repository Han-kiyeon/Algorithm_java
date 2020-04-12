package BOJ.Graph;

import java.util.Scanner;

public class Gold3_1507_궁금한민호 {
	static int N;
	static int[][] map, graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		graph = new int[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j] = map[i][j]= sc.nextInt();
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
						map[i][j] = 0;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans >> 1);

	}
}