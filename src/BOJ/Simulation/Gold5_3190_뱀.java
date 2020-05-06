package BOJ.Simulation;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Silver1_3190_뱀.java
 *
 * @Date : 2020. 5. 6.
 * @작성자 : 한기연
 * @메모리 : 15248 kb
 * @실행시간 : 140 ms
 *
 * @Blog : __
 **/
public class Gold5_3190_뱀 {
	static int N, K, L;
	static int[][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 보드의 크기 N
		K = sc.nextInt(); // 사과의 개수 K

		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
		}

		L = sc.nextInt(); // 뱀의 방향 변환 횟수 L
		LinkedList<int[]> cmd = new LinkedList<>();

		for (int i = 0; i < L; i++) {
			int t = sc.nextInt();
			int d = sc.next().charAt(0) == 'L' ? -1 : 1;
			cmd.add(new int[] { t, d });
		}

		int time = 0;
		int dir = 1;
		LinkedList<int[]> snake = new LinkedList<>();
		snake.add(new int[] { 0, 0 });
		while (true) {
			time++;
			int[] head = snake.getLast();

			int[] tail = snake.getFirst();
			int nr = head[0] + dr[dir];
			int nc = head[1] + dc[dir];

			if (!isRange(nr, nc))
				break;

			if (map[nr][nc] == 0) {
				snake.add(new int[] { nr, nc });
				map[nr][nc] = 2;
				map[tail[0]][tail[1]] = 0;
				snake.remove(0);
			} else if (map[nr][nc] == 1) {
				snake.add(new int[] { nr, nc });
				map[nr][nc] = 2;
			} else
				break;

			if (!cmd.isEmpty() && time == cmd.getFirst()[0]) {
				if (cmd.getFirst()[1] == 1) { // 오른쪽
					if (dir == 3)
						dir = 0;
					else
						dir++;
				} else { // 왼쪽
					if (dir == 0)
						dir = 3;
					else
						dir--;
				}
				cmd.remove(0);
			}
		}
		System.out.println(time);

	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < N)
			return true;
		return false;
	}
}