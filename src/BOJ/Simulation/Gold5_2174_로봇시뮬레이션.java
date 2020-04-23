package BOJ.Simulation;
import java.util.Scanner;

public class Gold5_2174_로봇시뮬레이션 {
	static int H, W;
	static int[][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Robot {
		int r, c;
		int dir;

		public Robot(int r, int c, char dir) {
			this.r = r;
			this.c = c;
			switch (dir) {
			case 'N':
				this.dir = 0;
				break;
			case 'E':
				this.dir = 1;
				break;
			case 'S':
				this.dir = 2;
				break;
			case 'W':
				this.dir = 3;
				break;
			}
		}

		public void L() {
			if (this.dir == 0)
				this.dir = 3;
			else
				this.dir--;
		}

		public void R() {
			if (this.dir == 3)
				this.dir = 0;
			else
				this.dir++;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];

		int N = sc.nextInt();
		int M = sc.nextInt();

		Robot[] robot = new Robot[N + 1];
		for (int i = 1; i <= N; i++) {
			int c = sc.nextInt() - 1;
			int r = H - sc.nextInt();
			char dir = sc.next().charAt(0);
			robot[i] = new Robot(r, c, dir);
			map[r][c] = i;
		}

		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			char cmd = sc.next().charAt(0);
			int times = sc.nextInt();
			for (int k = 0; k < times; k++) {
				switch (cmd) {
				case 'L':
					robot[num].L();
					break;
				case 'R':
					robot[num].R();
					break;
				case 'F':
					int r = robot[num].r;
					int c = robot[num].c;

					int nr = r + dr[robot[num].dir];
					int nc = c + dc[robot[num].dir];
					if (!isRange(nr, nc)) {
						System.out.println("Robot " + num + " crashes into the wall");
						System.exit(0);
					}
					if (map[nr][nc] != 0) {
						System.out.println("Robot " + num + " crashes into robot " + map[nr][nc]);
						System.exit(0);
					}
					robot[num].r = nr;
					robot[num].c = nc;
					map[r][c] = 0;
					map[nr][nc] = num;
					break;
				}
			}
		}
		System.out.println("OK");
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < H && 0 <= nc && nc < W)
			return true;
		return false;
	}
}
