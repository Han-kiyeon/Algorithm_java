package BOJ.Simulation;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Gold4_9872_미친아두이노.java
 *
 * @Date : 2020. 6. 3.
 * @작성자 : 한기연
 * @메모리 : 21964 kb
 * @실행시간 : 220 ms
 *
 * @Blog : __
 **/
public class Gold4_9872_미친아두이노 {
	static int R, C;
	static char[][] map;
	static int[] dr = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dc = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	static Point me;
	static String input;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "(r=" + r + ", c=" + c + ")";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					map[i][j] = '.';
					me = new Point(i, j);
				}
			}
		}

		input = sc.next();
		int len = input.length();
		int ret = solve();
		if (len != ret)
			System.out.println("kraj " + ret);
		else
			printmap();
	}

	private static void printmap() {
		map[me.r][me.c] = 'I';
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int solve() {
		for (int times = 0; times < input.length(); times++) {
			int cmd = input.charAt(times) - '0';
			me.r += dr[cmd];
			me.c += dc[cmd];
			if (map[me.r][me.c] == 'R')
				return times + 1;
			boolean[][] visit = new boolean[R][C];
			boolean[][] move = new boolean[R][C];

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 'R')
						continue;
					int r = i, c = j;
					if (r < me.r)
						r++;
					else if (r > me.r)
						r--;

					if (c < me.c)
						c++;
					else if (c > me.c)
						c--;

					if (r == me.r && c == me.c)
						return times + 1;

					if (!visit[r][c]) {
						visit[r][c] = true;
						move[r][c] = true;
					} else {
						move[r][c] = false;
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (move[i][j])
						map[i][j] = 'R';
					else
						map[i][j] = '.';
				}
			}

		}
		return input.length();
	}

}