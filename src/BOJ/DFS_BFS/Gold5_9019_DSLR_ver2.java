package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold5_9019_DSLR_ver2.java
 *
 * @Date : 2020. 3. 21.
 * @작성자 : 한기연
 * @메모리 : 373232 kb
 * @실행시간 : 3836 ms
 *
 * @Blog : __
 **/

public class Gold5_9019_DSLR_ver2 {
	static class Number {
		int num;
		String command;

		public Number(int num, String command) {
			this.num = num;
			this.command = command;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			boolean[] visit = new boolean[10001];
			Queue<Number> q = new LinkedList<>();
			q.offer(new Number(A, ""));
			visit[A] = true;

			while (!q.isEmpty()) {
				int now = q.peek().num;
				String command = q.peek().command;
				q.poll();

				if (now == B) {
					System.out.println(command);
					break;
				}

				int next = (now * 2) % 10000;
				if (!visit[next]) {
					visit[next] = true;
					q.offer(new Number(next, command + "D"));
				}
				next = now == 0 ? 9999 : now - 1;
				if (!visit[next]) {
					visit[next] = true;
					q.offer(new Number(next, command + "S"));
				}

				next = now / 1000 + (now % 1000) * 10;
				if (!visit[next]) {
					visit[next] = true;
					q.offer(new Number(next, command + "L"));
				}
				next = now % 10 * 1000 + now / 10;
				if (!visit[next]) {
					visit[next] = true;
					q.offer(new Number(next, command + "R"));
				}
			}
		} // end of TC
	}

}