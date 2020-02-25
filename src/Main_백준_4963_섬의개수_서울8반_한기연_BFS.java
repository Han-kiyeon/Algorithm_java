import java.io.*;
import java.util.*;

public class Main_백준_4963_섬의개수_서울8반_한기연_BFS {
	static int W, H;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();

			if (W == 0 && H == 0)
				break;

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					int tmp = sc.nextInt();
					if (tmp == 1)
						map[i][j] = -1;
					else
						map[i][j] = tmp;
				}
			}

			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == -1) {
						solve(i, j, ++cnt);
					}
				}
			}
			System.out.println(cnt);

			// for(int[] is : map)
			// System.out.println(Arrays.toString(is));

		} // end of tc
		sc.close();
	}// end of main

	private static void solve(int i, int j, int cnt) {
		int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 };
		int[] dc = { 0, 0, -1, 1, 1, -1, -1, 1 };

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		map[i][j] = cnt;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int k = 0; k < 8; k++) {
				int r = tmp[0] + dr[k];
				int c = tmp[1] + dc[k];
				if (range(r, c)) {
					if (map[r][c] == -1) {
						q.offer(new int[] { r, c });
						map[r][c] = cnt;
					}
				}
			}
		}
	}

	private static boolean range(int r, int c) {
		if (0 <= r && r < H && 0 <= c && c < W)
			return true;
		return false;
	}

}
