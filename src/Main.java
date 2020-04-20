import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N은 2 이상 100 이하의 정수
		map = new int[N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt(); // 높이는 1이상 100 이하의 정수
				if (max < map[i][j])
					max = map[i][j];
			}
		}
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
//		System.out.println();
//		System.out.println(max);
		int ans = 0;
		for (int i = 0; i < max; i++) {
			int tmp = BFS(i);
//			System.out.println(tmp);
			if (ans < tmp)
				ans = tmp;
		}
		System.out.println(ans);
	}

	private static int BFS(int x) {
		boolean[][] visit = new boolean[N][N];
		boolean[][] tmp = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] - x > 0)
					tmp[i][j] = true;
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (tmp[i][j])
//					System.out.print(1 + " ");
//				else
//					System.out.print(0 + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] || !tmp[i][j])
					continue;
				cnt++;
				q.add(new int[] { i, j });
				visit[i][j] = true;
				while (!q.isEmpty()) {
					int[] now = q.poll();

					for (int k = 0; k < dr.length; k++) {
						int nr = now[0] + dr[k];
						int nc = now[1] + dc[k];
						if (isRange(nr, nc) && !visit[nr][nc] && tmp[nr][nc]) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
						}
					}
				}
			}
		}
		return cnt;
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < N)
			return true;
		return false;
	}
}