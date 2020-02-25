import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_16234_인구이동_서울8반_한기연 {
	static int N, L, R, num;
	static int[][] map, connect;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
		N = sc.nextInt();
		// 두 나라의 인구 차이가 L명 이상, R명 이하라면
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();

		int ans = 0;
		while (true) {

			connect = new int[N][N];
			num = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (connect[i][j] == 0) {
						if (DFS(i, j, num))
							num++;
					}
				}
			}
			
			if (num == 1) {
				System.out.println(ans);
				return;
			}

			int[] cnts = new int[num];
			int[] sums = new int[num];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sums[connect[i][j]] += map[i][j];
					cnts[connect[i][j]]++;
				}
			}
			
			for (int i = 1; i < num; i++)
				sums[i] /= cnts[i];

			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (connect[i][j] != 0)
						map[i][j] = sums[connect[i][j]];
			ans++;
		}
	}

	private static boolean DFS(int i, int j, int num) {
		boolean flag = false;
		for (int k = 0; k < 4; k++) {
			int r = i + dr[k];
			int c = j + dc[k];
			if (isRange(r, c) && connect[r][c] == 0) {
				int dif = Math.abs(map[i][j] - map[r][c]);
				if (L <= dif && dif <= R) {
					connect[r][c] = num;
					DFS(r, c, num);
					flag = true;
				}
			}
		}
		if (flag) {
			connect[i][j] = num;
			return true;
		}
		return false;
	}

	private static boolean isRange(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < N)
			return true;
		return false;
	}

}
