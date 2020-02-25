import java.io.*;
import java.util.*;

public class Main_백준_1012_유기농배추_한기연 {
	static int T, N, M, K, res;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/백준_1012_유기농배추.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
//			for (int[] m : map)
//				System.out.println(Arrays.toString(m));
//			System.out.println();

			res = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						map[i][j] = 2;
						solve(i, j);
						res++;
					}
				}
			}
//			for (int[] m : map)
//				System.out.println(Arrays.toString(m));
//			System.out.println();

			System.out.println(res);
		} // end of TC
	}// end of main

	static void solve(int i, int j) {

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (range(x, y)) {
				if (map[x][y] == 1) {
					map[x][y] = 2;
					solve(x, y);
				}
			}
		}
	}

	static boolean range(int x, int y) {
		if (0 <= x && x < M && 0 <= y && y < N)
			return true;
		return false;
	}

}
