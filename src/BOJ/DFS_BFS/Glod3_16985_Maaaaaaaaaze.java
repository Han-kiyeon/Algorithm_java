package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Glod3_16985_Maaaaaaaaaze.java
 *
 * @Date : 2020. 2. 11.
 * @작성자 : 한기연
 * @메모리 : 279664 kb
 * @실행시간 : 1176 ms
 *
 * @Blog : https://herong.tistory.com/entry/BOJ-16985-Maaaaaaaaaze-GraphBFBFS
 **/

public class Glod3_16985_Maaaaaaaaaze {
	static int[][][][] map = new int[5][4][5][5];
	static int[] solData = new int[5], goData = new int[5];
	static boolean[] visit = new boolean[5];
	static int ans;
//상하좌우 아래 위
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					map[k][0][i][j] = sc.nextInt();
				}
			}
			rotateMap(k);
		}
//		for (int k = 0; k < 4; k++) {
//			for (int i = 0; i < 5; i++) {
//				System.out.println(Arrays.toString(map[0][k][i]));
//			}
//			System.out.println();
//		}

		ans = Integer.MAX_VALUE;

		solve(0); // 각 판의 회전 정도를 결정

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void solve(int depth) {
		if (depth == 5) {
			go(0); // 판의 순서를 결정
			return;
		}
		for (int i = 0; i < 4; i++) {
			solData[depth] = i;
			solve(depth + 1);
		}
	}

	private static void go(int depth) {
		if (depth == 5) {
			calc();
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!visit[i]) {
				visit[i] = true;
				goData[depth] = i;
				go(depth + 1);
				visit[i] = false;
			}
		}
	}

	private static void calc() {
		int[][][] copy = new int[5][5][5];
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					copy[k][i][j] = map[goData[k]][solData[k]][i][j];
				}
			}
		}
		// BFS
		// 입구나 출구가 없는 경우
		if (copy[0][0][0] != 1 || copy[4][4][4] != 1)
			return;

		Queue<int[]> q = new LinkedList<>();
		boolean visit[][][] = new boolean[5][5][5];
		q.offer(new int[] { 0, 0, 0, 0 });
		visit[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			// 최저값 보다 클 경우 종료
			if (cur[3] >= ans)
				return;
			// 도착 종료
			if (cur[0] == 4 && cur[1] == 4 && cur[2] == 4) {
				if (ans > cur[3])
					ans = cur[3];
				return;
			}
			for (int dir = 0; dir < 6; dir++) {
				int nz = cur[0] + dz[dir];
				int ny = cur[1] + dy[dir];
				int nx = cur[2] + dx[dir];
				if (isRange(nz, ny, nx) && !visit[nz][ny][nx] && copy[nz][ny][nx] == 1) {
					q.offer(new int[] { nz, ny, nx, cur[3] + 1 });
					visit[nz][ny][nx] = true;
				}
			}
		}
	}

	private static boolean isRange(int nz, int ny, int nx) {
		if (0 <= nz && nz < 5 && 0 <= ny && ny < 5 && 0 <= nx && nx < 5)
			return true;
		return false;
	}

	private static void rotateMap(int k) {
		for (int turn = 1; turn < 4; turn++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					map[k][turn][j][4 - i] = map[k][turn - 1][i][j];
				}
			}
		}
	}
}
