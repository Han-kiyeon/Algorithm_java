package BOJ.DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold5_12851_숨바꼭질2.java
 *
 * @Date : 2020. 3. 22.
 * @작성자 : 한기연
 * @메모리 : 48664 kb
 * @실행시간 : 236 ms
 *
 * @Blog : __
 **/

public class Gold5_12851_숨바꼭질2 {
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		boolean[] visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { N, 0 });
		visited[N] = true;

		int[] next = new int[3];
		int time = Integer.MAX_VALUE;
		int count = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[1] > time)
				continue;
			else if (now[0] == K) {
				if (time > now[1]) {
					time = now[1];
					count = 1;
				} else if (time == now[1])
					count++;
			}

			visited[now[0]] = true;

			next[0] = now[0] - 1;
			next[1] = now[0] + 1;
			next[2] = now[0] << 1;

			for (int i = 0; i < 3; i++) {
				if (0 <= next[i] && next[i] <= 100000 && !visited[next[i]])
					q.add(new int[] { next[i], now[1] + 1 });
			}
		}
		System.out.println(time);
		System.out.println(count);
	}

}