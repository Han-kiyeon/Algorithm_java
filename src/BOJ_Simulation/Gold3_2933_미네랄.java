package BOJ_Simulation;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ_Simulation
 * @FileName : Gold3_2933_미네랄.java
 *
 * @Date : 2020. 2. 25.
 * @작성자 : 한기연
 * @메모리 : 54368 kb
 * @실행시간 : 468 ms
 *
 * @Blog : __
 **/
public class Gold3_2933_미네랄 {
	static int R, C, cnt;
	static char[][] map;
	static int[][] visit;

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		cnt = 0;
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'x')
					cnt++;
			}
		}
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int floor = R - sc.nextInt();
			if (i % 2 == 0) {
				// 왼쪽에서 오른쪽으로 이동
				for (int j = 0; j < C; j++) {
					if (map[floor][j] == 'x') {
						map[floor][j] = '.';
						cnt--;
						break;
					}
				}
			} else {
				// 오른쪽에서 왼쪽으로 이동
				for (int j = C - 1; j >= 0; j--) {
					if (map[floor][j] == 'x') {
						map[floor][j] = '.';
						cnt--;
						break;
					}
				}
			}
			if (cnt != BFS()) {
				down();
			}

		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void down() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'x' && visit[i][j] == 0) { // 공중에 떠있는 클러스터 표시
					visit[i][j] = 2;
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int dir = 0; dir < dr.length; dir++) {
							int r = cur[0] + dr[dir];
							int c = cur[1] + dc[dir];
							if (isRange(r, c) && map[r][c] == 'x' && visit[r][c] == 0) {
								visit[r][c] = 2;
								q.add(new int[] { r, c });
							}
						}
					} // end of while
				}
			}
		} // 표시 끝

		// 내리자(몇칸????)
		int h = 1234567890;
		int cnt = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] == 2) { // 내려갈 수 있는 값을 구한다.
					cnt = 0;
					for (int r = i + 1; r < R; r++) {
						if (visit[r][j] == 1) {
							// 아랫칸이 같은 클러스터가 아니라면
							break;
						} else if (visit[r][j] == 2) {
							cnt = h;
							break;
						} else
							cnt++;
					}
					if (h > cnt)
						h = cnt;
				} // end of if
			}
		}

		// h칸만큼 내린다.
		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] == 2) {
					map[i][j] = '.';
					map[i + h][j] = 'x';
				}
			}
		}

	}

	static int BFS() {
		int ret = 0;
		Queue<int[]> q = new LinkedList<>();
		visit = new int[R][C];

		for (int j = 0; j < C; j++) { // 바닥에 붙어있는 부분 만 검사
			if (map[R - 1][j] == 'x' && visit[R - 1][j] == 0) {
				visit[R - 1][j] = 1;
				ret++;
				q.add(new int[] { R - 1, j });

				while (!q.isEmpty()) {
					int[] cur = q.poll();
					for (int dir = 0; dir < dr.length; dir++) {
						int r = cur[0] + dr[dir];
						int c = cur[1] + dc[dir];
						if (isRange(r, c) && map[r][c] == 'x' && visit[r][c] == 0) {
							visit[r][c] = 1;
							ret++;
							q.add(new int[] { r, c });
						}
					}
				} // end of while

			}
		}
		return ret;

	}

	private static boolean isRange(int r, int c) {
		if (0 <= r && r < R && 0 <= c && c < C)
			return true;
		return false;
	}

}
