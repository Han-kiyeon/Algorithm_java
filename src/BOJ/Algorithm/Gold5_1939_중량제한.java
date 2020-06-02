package BOJ.Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Algorithm
 * @FileName : Gold5_1939_중량제한.java
 *
 * @Date : 2020. 6. 3.
 * @작성자 : 한기연
 * @메모리 : 243520 kb
 * @실행시간 : 1240 ms
 *
 * @Blog : __
 **/
public class Gold5_1939_중량제한 {

	static ArrayList<int[]>[] graph;
	static int N, M, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		graph = new ArrayList[N];
		for (int i = 0; i < N; ++i) {
			graph[i] = new ArrayList<>();
		}

		max = 0;
		for (int i = 0; i < M; ++i) {
			int A = sc.nextInt() - 1;
			int B = sc.nextInt() - 1;
			int C = sc.nextInt();

			max = C > max ? C : max;

			graph[A].add(new int[] { B, C });
			graph[B].add(new int[] { A, C });
		}

		int from = sc.nextInt() - 1;
		int to = sc.nextInt() - 1;

		System.out.println(binarySearch(from, to));

	}

	private static long binarySearch(int from, int to) {
		long left = 1;
		long right = max;
		long mid = 0;
		long ans = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (go(from, to, mid)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return ans;
	}

	private static boolean go(int from, int to, long weight) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];

		q.offer(from);
		visited[from] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == to) {
				return true;
			}

			for (int[] next : graph[now]) {
				if (!visited[next[0]] && next[1] >= weight) {
					q.offer(next[0]);
					visited[next[0]] = true;
				}
			}
		}

		return false;
	}
}