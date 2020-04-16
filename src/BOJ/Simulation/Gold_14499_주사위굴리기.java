package BOJ.Simulation;
import java.nio.channels.SelectableChannel;
import java.util.Scanner;

public class Gold_14499_주사위굴리기 {
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	static class Dice {
		// ..0
		// 1 2 3
		// ..4
		// ..5

		int[] value;

		public Dice() {
			this.value = new int[6];
		}

		int getTop() {
			return value[2];
		}

		int getButtom() {
			return value[5];
		}

		void setButtom(int x) {
			value[5] = x;
		}

		void move(int dir) {
			switch (dir) {
			case 1:
				right();
				break;
			case 2:
				left();
				break;
			case 3:
				up();
				break;
			case 4:
				down();
				break;

			}
		}

		void up() {
			int tmp = value[0];
			value[0] = value[2];
			value[2] = value[4];
			value[4] = value[5];
			value[5] = tmp;
		}

		void down() {
			int tmp = value[5];
			value[5] = value[4];
			value[4] = value[2];
			value[2] = value[0];
			value[0] = tmp;
		}

		void right() {
			int tmp = value[3];
			value[3] = value[2];
			value[2] = value[1];
			value[1] = value[5];
			value[5] = tmp;
		}

		void left() {
			int tmp = value[1];
			value[1] = value[2];
			value[2] = value[3];
			value[3] = value[5];
			value[5] = tmp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int r = sc.nextInt();
		int c = sc.nextInt();

		Dice d = new Dice();

		int K = sc.nextInt();

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < K; i++) {
			int dir = sc.nextInt();
			r += dr[dir];
			c += dc[dir];
			if (r < 0 || r >= N || c < 0 || c >= M) {
				r -= dr[dir];
				c -= dc[dir];
				continue;
			}
			d.move(dir);

			if (map[r][c] == 0)
				map[r][c] = d.getButtom();
			else {
				d.setButtom(map[r][c]);
				map[r][c] = 0;
			}
			System.out.println(d.getTop());
		}
	}
}