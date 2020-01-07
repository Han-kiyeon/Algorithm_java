package BOJ.BF;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold4_17779_게리멘더링2.java
 *
 * @Date : 2020. 5. 17.
 * @작성자 : 한기연
 * @메모리 : 17256 kb
 * @실행시간 : 244 ms
 *
 * @Blog : __
 **/
public class Gold4_17779_게리멘더링2 {
	static int N, ans;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solve(i, j);
			}
		}
		System.out.println(ans);
	}

	private static void solve(int x, int y) {
		for (int d1 = 1; d1 < N; d1++) {
			for (int d2 = 1; d2 < N; d2++) {
				if (check(x, y, d1, d2)) {
					calc(x, y, d1, d2);
				}
			}
		}
	}

	private static void calc(int x, int y, int d1, int d2) {
		int[] sum = new int[5];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (r + c >= x + y && // Math.abs((0) - (x)) + Math.abs((0) - (y))
						r + c <= x + y + 2 * d2 && // Math.abs((0) - (x + d1 + d2)) + Math.abs((0) - (y + d2 - d1))
						r + (N - c) >= x + N - y && // Math.abs((0) - (x)) + Math.abs((N) - (y))
						r + (N - c) <= x + N - y + 2 * d1) {// Math.abs((0) - (x + d1)) + Math.abs((N) - (y - d1)))
					// map[r][c] = 5;
					sum[0] += map[r][c];
					continue;
				}

				if (r < x + d1 && c <= y) {
					// map[r][c] = 1;
					sum[1] += map[r][c];
				} else if (r <= x + d2 && y < c) {
					// map[r][c] = 2;
					sum[2] += map[r][c];
				} else if (x + d1 <= r && c < y - d1 + d2) {
					// map[r][c] = 3;
					sum[3] += map[r][c];
				} else if (x + d2 <= r && y - d1 + d2 <= c) {
					// map[r][c] = 4;
					sum[4] += map[r][c];
				}
			}
		}

		int min = sum[0];
		int max = sum[0];
		for (int i = 1; i < 5; i++) {
			if (min > sum[i])
				min = sum[i];
			if (max < sum[i])
				max = sum[i];
		}

		if (ans > max - min)
			ans = max - min;
	}

	private static boolean check(int x, int y, int d1, int d2) {
		if ((0 <= x + d1 + d2 && x + d1 + d2 < N)
				&& (0 <= y - d1 && y - d1 < y && y < y + d2 && y + d2 < N))
			return true;
		return false;

	}
}