package BOJ.Simulation;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Gold3_17822_원판돌리기.java
 *
 * @Date : 2020. 6. 1.
 * @작성자 : 한기연
 * @메모리 : 31940 kb
 * @실행시간 : 328 ms
 *
 * @Blog : __
 **/
public class Gold3_17822_원판돌리기{
	static int N, M, T;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int t = 0; t < T; t++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();
			rotate(x, d, k);
			if (!remove())
				replace();
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1)
					ans += map[i][j];
			}
		}
		System.out.println(ans);
	}

	private static void replace() {
		int sum = 0, cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					sum += map[i][j];
					cnt++;
				}
			}
		}
		double avg = sum / (double) cnt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					if ((double) map[i][j] > avg)
						map[i][j]--;
					else if ((double) map[i][j] < avg)
						map[i][j]++;
				}
			}
		}
	}

	private static boolean remove() {
		boolean flag = false;
		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1 || visit[i][j])
					continue;
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] { i, j, map[i][j] });
				visit[i][j] = true;
				while (!q.isEmpty()) {
					int[] now = q.poll();
					for (int k = 0; k < dr.length; k++) {
						int nr = now[0] + dr[k];
						int nc = now[1] + dc[k];

						if (nr < 0 || nr >= N)
							continue;

						if (nc == -1)
							nc = M - 1;
						else if (nc == M)
							nc = 0;
						if (visit[nr][nc])
							continue;
						if (map[nr][nc] == now[2]) {
							visit[nr][nc] = true;
							q.add(new int[] { nr, nc, now[2] });
							map[now[0]][now[1]] = -1;
							map[nr][nc] = -1;
							flag = true;
						}
					}
				}
			}
		}
		return flag;
	}

	private static void rotate(int x, int d, int k) {
		for (int r = 0; r < N; r++) {
			if ((r + 1) % x != 0)
				continue;
			if (d == 0) {
				// 시계방향 회전
				for (int times = 0; times < k; times++) {
					// k 칸 이동
					int[] tmp = map[r].clone();
					map[r][0] = tmp[M - 1];
					for (int i = 1; i < M; i++) {
						map[r][i] = tmp[i - 1];
					}
				}
			} else {
				// 반시계 방향 회전
				for (int times = 0; times < k; times++) {
					// k 칸 이동
					int[] tmp = map[r].clone();
					map[r][M - 1] = tmp[0];
					for (int i = 0; i < M - 1; i++) {
						map[r][i] = tmp[i + 1];
					}
				}
			}
		}
	}

}