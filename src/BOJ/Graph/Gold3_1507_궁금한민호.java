package BOJ.Graph;

import java.util.Scanner;

public class Gold3_1507_궁금한민호 {
	static int N;
	static int[][] a, dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		dist = new int[N][N];
		a = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = a[i][j]= sc.nextInt();
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < N; j++) {
					if (k == j || i == j)
						continue;
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						System.out.println(-1);
						return;
					}
					if (dist[i][j] == dist[i][k] + dist[k][j])
						a[i][j] = 0;
					
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				ans += a[i][j];
			}
		}
		System.out.println(ans);

	}
}