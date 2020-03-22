package BOJ.DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Silver1_2251_물통.java
 *
 * @Date : 2020. 3. 22.
 * @작성자 : 한기연
 * @메모리 : 23520 kb
 * @실행시간 : 112 ms
 *
 * @Blog : __
 **/
public class Silver1_2251_물통 {
	static int[] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[3];
		input[0] = sc.nextInt();
		input[1] = sc.nextInt();
		input[2] = sc.nextInt();

		Queue<int[]> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		boolean[][][] visit = new boolean[input[0] + 1][input[1] + 1][input[2] + 1];
		visit[0][0][input[2]] = true;
		set.add(input[2]);
		q.offer(new int[] { 0, 0, input[2] });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (now[0] == 0) {
				set.add(now[2]);
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == j)
						continue;
					int[] next = solve(now, i, j);
					if (!visit[next[0]][next[1]][next[2]]) {
						visit[next[0]][next[1]][next[2]] = true;
						q.offer(next);
					}
				}
			}
		}

		ArrayList<Integer> ans = new ArrayList<>(set);
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		for (Integer i : ans) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	private static int[] solve(int[] now, int i, int j) {
		if (now[i] == 0 || now[j] == input[j]) {
			return now;
		}

		// from i to j;
		int[] next = now.clone();
		int tmp = input[j] - next[j];
		if (next[i] > tmp) {
			next[j] += tmp;
			next[i] -= tmp;
		} else {
			next[j] += next[i];
			next[i] = 0;
		}

		return next;
	}
}