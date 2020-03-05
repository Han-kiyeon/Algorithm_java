package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D4_5684_운동.java
 *
 * @Date : 2020. 3. 5.
 * @작성자 : 한기연
 * @메모리 : 106,528 kb
 * @실행시간 : 401 ms
 *
 * @Blog : __
 **/
public class D4_5684_운동 {
	static int N, M, ans;
	static int[][] map;

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// (1 ≤ T ≤ 20)
		for (int tc = 1; tc <= T; tc++) {
			// (2 ≤ N ≤ 400, 2 ≤ M ≤ N*(N-1))
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < M; i++) {
				map[sc.nextInt() - 1][sc.nextInt() - 1] = sc.nextInt(); // 거리는 10,000 이하의 자연수
			}
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				BFS(i);
			}
			System.out.println("#" + tc + " " + (ans == Integer.MAX_VALUE ? -1 : ans));
		}
	}// end of main

	private static void BFS(int start) {
		boolean visit[] = new boolean[N];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { start, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < N; i++) {
				if (map[cur[0]][i] != 0 && !visit[i]) {
					visit[cur[0]] = true;
					q.offer(new int[] { i, cur[1] + map[cur[0]][i] });
				}
				if (map[cur[0]][i] != 0 && i == start) {
					if (ans > cur[1] + map[cur[0]][i])
						ans = cur[1] + map[cur[0]][i];
					return;
				}
			}
		}
	}

}
