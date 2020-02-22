package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Silver1_1697_숨바꼭질.java
 *
 * @Date : 2020. 2. 22.
 * @작성자 : 한기연
 * @메모리 : 19028 kb
 * @실행시간 : 148 ms
 *
 * @Blog : __
 **/

public class Silver1_1697_숨바꼭질 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] visit = new int[100001];
		Queue<Integer> q = new LinkedList<Integer>();
		visit[N] = 1;
		q.offer(N);

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == K) {
				System.out.println(visit[cur] - 1);
				return;
			}
			int next = cur << 1;
			if (isRange(next) && visit[next] == 0) {
				q.offer(next);
				visit[next] = visit[cur] + 1;
			}
			next = cur + 1;
			if (isRange(next) && visit[next] == 0) {
				q.offer(next);
				visit[next] = visit[cur] + 1;
			}
			next = cur - 1;
			if (isRange(next) && visit[next] == 0) {
				q.offer(next);
				visit[next] = visit[cur] + 1;
			}

		}

	}

	private static boolean isRange(int x) {
		if (0 <= x && x <= 100000)
			return true;
		return false;
	}
}