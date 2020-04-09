package BOJ.BF;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold3_16998_Baaaaaaaaaduk2_Easy.java
 *
 * @Date : 2020. 4. 10.
 * @작성자 : 한기연
 * @메모리 : 279112 kb
 * @실행시간 : 628 ms
 *
 * @Blog : __
 **/
public class Gold3_16998_Baaaaaaaaaduk2_Easy {
	static int N, M, ans;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 돌을 선택
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0)
					continue;
				for (int ii = 0; ii < N; ii++) {
					for (int jj = 0; jj < M; jj++) {
						if (map[ii][jj] != 0 || (ii == i && jj == j))
							continue;
						map[i][j] = 1;
						map[ii][jj] = 1;
						solve();
						map[i][j] = 0;
						map[ii][jj] = 0;
					}
				}
			}
		}
		System.out.println(ans);
	}

	private static void solve() {
		int sum = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 2 || visit[i][j])
					continue;

				visit[i][j] = true;
				q.offer(new int[] { i, j });
				int tmp = 1;
				boolean flag = true;
				while (!q.isEmpty()) {
					int[] now = q.poll();
					for (int k = 0; k < dr.length; k++) {
						int nr = now[0] + dr[k];
						int nc = now[1] + dc[k];
						if (isRange(nr, nc)) {
							if (map[nr][nc] == 0) {
								flag = false;
							} else if (map[nr][nc] == 2 && !visit[nr][nc]) {
								visit[nr][nc] = true;
								tmp++;
								q.offer(new int[] { nr, nc });
							}
						} // end of isRange
					}
				} // end of while
				if (flag) {
					sum += tmp;
				}
			}
		}
		if (ans < sum)
			ans = sum;
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < M)
			return true;
		return false;
	}
}