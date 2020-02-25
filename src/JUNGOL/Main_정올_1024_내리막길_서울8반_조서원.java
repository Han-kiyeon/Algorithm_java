package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1024_내리막길_서울8반_조서원 {

	public static int[] di = { 0, 0, -1, 1 };
	public static int[] dj = { -1, 1, 0, 0 };
	public static int H, W, map[][], memoization[][];

	public static int way(int i, int j) {
		if (i == H - 1 && j == W - 1) {
			return 1;
		}

		if (memoization[i][j] == -1) {
			memoization[i][j] = 0;

			for (int k = 0; k < 4; k++) {
				int ni = i + di[k];
				int nj = j + dj[k];

				if (0 <= ni && ni < H && 0 <= nj && nj < W && map[ni][nj] < map[i][j]) {
					memoization[i][j] += way(ni, nj);
				}
			}
		}
		return memoization[i][j];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken()); // 세로
		W = Integer.parseInt(st.nextToken()); // 가로

		map = new int[H][W];
		memoization = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memoization[i][j] = -1;
			}
		}

		System.out.println(way(0, 0));
		for (int i = 0; i < H; i++) {
			System.out.println(Arrays.toString(memoization[i]));
		}
	}
}

/*
 4 5 50 45 37 32 30 35 50 40 20 25 30 30 25 17 28 27 24 22 15 10

 3
 */