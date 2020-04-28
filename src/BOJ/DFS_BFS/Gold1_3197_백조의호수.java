package BOJ.DFS_BFS;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gold1_3197_백조의호수 {
	static int R, C;
	static char[][] map;
	static Point[] swan;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<int[]> swanQ;
	static Queue<int[]> waterQ;

	static boolean[][] visit_swan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		swan = new Point[2];

		swanQ = new LinkedList<>();
		visit_swan = new boolean[R][C];

		waterQ = new LinkedList<>();

		// 데이터 입력
		int index = 0;
		for (int i = 0; i < R; ++i) {
			String line = sc.next();
			for (int j = 0; j < C; ++j) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'L') {
					map[i][j] = '.';
					swan[index++] = new Point(i, j);
				}
				if (map[i][j] == '.') {
					waterQ.add(new int[] { i, j });
				}
			}
		}

		// 출발점이 되는 백조
		swanQ.add(new int[] { swan[0].x, swan[0].y });
		visit_swan[swan[0].x][swan[0].y] = true;

		int day = 0;
		while (true) {
			if (move_swan())
				break;
			melt();
			day++;
		}

		System.out.println(day);
	}

	private static boolean move_swan() {
		Queue<int[]> nextQ = new LinkedList<>();
		while (!swanQ.isEmpty()) {
			int[] now = swanQ.poll();

			if (now[0] == swan[1].x && now[1] == swan[1].y) {
				return true;
			}

			for (int k = 0; k < 4; ++k) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];

				if (!isRange(nr, nc) || visit_swan[nr][nc])
					continue;
				visit_swan[nr][nc] = true;
				if (map[nr][nc] == '.') {
					swanQ.add(new int[] { nr, nc });
				}
				// 다음날 얼음이 녹아 백조가 지나 갈 수 있음.
				else if (map[nr][nc] == 'X') {
					nextQ.add(new int[] { nr, nc });
				}
			}
		}
		// q를 다음날 탐색할 지역이 담긴 nextQ로 바꾼다.
		swanQ = nextQ;
		return false;
	}

	private static void melt() {
		// 얼음을 녹인다.
		int size = waterQ.size();
		for (int i = 0; i < size; ++i) {
			int[] now = waterQ.poll();

			for (int k = 0; k < 4; ++k) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];

				// 물에 인접한 얼음을 발견하면 녹이고 다시 큐에 넣는다.
				if (isRange(nr, nc) && map[nr][nc] == 'X') {
					map[nr][nc] = '.';
					waterQ.add(new int[] { nr, nc });
				}
			}
		}
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < R && 0 <= nc && nc < C)
			return true;
		return false;
	}
}