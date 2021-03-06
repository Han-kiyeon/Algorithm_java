package BOJ.DFS_BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Silver1_7576_토마토_ver1.java
 *
 * @Date : 2019. 8. 16.
 * @작성자 : 한기연
 * @메모리 : 123040 kb
 * @실행시간 : 568 ms
 *
 * @Blog : __
 **/
public class Silver1_7576_토마토_ver1{
	// -------------------------//상, 하, 좌, 우
	public static int[] maskI = { -1, 1, 0, 0 };
	public static int[] maskJ = { 0, 0, -1, 1 };

	public static int N, M;

	public static boolean range(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < M)
			return true;
		else
			return false;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		Queue<Point> q = new LinkedList<>();

		int[][] matrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (matrix[i][j] == 1)
					q.offer(new Point(i, j));
			}
		}

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = tmp.x + maskI[i];
				int nj = tmp.y + maskJ[i];

				if (range(ni, nj) && matrix[ni][nj] == 0 && matrix[ni][nj] != -1) {
					q.offer(new Point(ni, nj));
					matrix[ni][nj] = matrix[tmp.x][tmp.y] + 1;				
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = (max > matrix[i][j]) ? max : matrix[i][j];
				if(matrix[i][j]==0) {
					max = -1;
					System.out.println(max);
					return;
				}
			}
		}
		System.out.println(max - 1);
	}
}