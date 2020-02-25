import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_14889_스타트와링크_서울8반_한기연 {
	static int[][] matrix;
	static int[] visit;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
		visit = new int[N];
		solve(N, N / 2, 0, 0);
		System.out.println(min);

	}

	static void solve(int n, int r, int depth, int start) {
		if(depth!=0&&visit[0]==0)
			return;
		if (depth == r) {
			int team1 = 0, team2 = 0;
			for (int i = 0; i < n; i++) {
				if (visit[i] == 1)
					for (int j = 0; j < n; j++) {
						if (i != j && visit[j] == 1)
							team1 += matrix[i][j];
					}
				else
					for (int j = 0; j < n; j++) {
						if (i != j && visit[j] == 0)
							team2 += matrix[i][j];
					}
			}
			int res = Math.abs(team1 - team2);
			if (res < min)
				min = res;
			return;
		}

		for (int i = start; i < n; i++) {
			if (visit[i] == 0) {
				visit[i] = 1;
				solve(n, r, depth + 1, i);
				visit[i] = 0;
			}
		}
	}
}
