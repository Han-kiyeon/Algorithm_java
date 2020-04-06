package BOJ_ETC;
import java.util.Scanner;

public class Silver3_2630_색종이만들기 {
	static int N, blue, white;
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
		blue = white = 0;

		solve(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void solve(int r, int c, int size) {
		int check = map[r][c];
		boolean flag = true;
		for (int i = r; i < r + size && flag; i++) {
			for (int j = c; j < c + size && flag; j++) {
				if (check != map[i][j]) {
					flag = false;
				}
			}
		}
		if (flag) {
			if (check == 0)
				white++;
			else
				blue++;
			return;
		}

		int half = size >> 1;
		solve(r, c, half);
		solve(r, c + half, half);
		solve(r + half, c, half);
		solve(r + half, c + half, half);
	}
}