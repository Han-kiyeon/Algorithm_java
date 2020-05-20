package BOJ.Simulation;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Gold3_18808_스티커붙이기.java
 *
 * @Date : 2020. 5. 20.
 * @작성자 : 한기연
 * @메모리 : 22800 kb
 * @실행시간 : 228 ms
 *
 * @Blog : __
 **/
public class Gold3_18808_스티커붙이기 {
	static int N, M, K, H, W;
	static int[][] map, sticker;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][M];
		for (int k = 0; k < K; k++) {
			H = sc.nextInt();
			W = sc.nextInt();
			sticker = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sticker[i][j] = sc.nextInt();
				}
			}
			go();
		}
		System.out.println(clac());
	}

	private static int clac() {
		int ret = 0;
		for (int[] is : map) {
			for (int i : is) {
				if (i == 1)
					ret++;
			}
		}
		return ret;
	}

	private static void go() {
		for (int k = 0; k < 4; k++) {
			int R = N - H;
			int C = M - W;
			for (int r = 0; r <= R; r++) {
				for (int c = 0; c <= C; c++) {
					if (check(r, c)) {
						return;
					}
				}
			}
			rotate();
		}
	}

	private static boolean check(int i, int j) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (sticker[r][c] == 1 && map[i + r][j + c] == 1)
					return false;
			}
		}

		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (sticker[r][c] == 1)
					map[i + r][j + c] = 1;
			}
		}
		return true;
	}

	private static void rotate() {
		int[][] rot = new int[W][H];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				rot[j][H - 1 - i] = sticker[i][j];
			}
		}
		int tmp = H;
		H = W;
		W = tmp;
		sticker = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sticker[i][j] = rot[i][j];
			}
		}
	}
}