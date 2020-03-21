import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			char[] path = new char[10001];
			int[] parent = new int[10001];
			Arrays.fill(parent, -1);

			Queue<Integer> q = new LinkedList<>();
			q.offer(A);
			parent[A] = A;
			path[A] = 'A';

			while (!q.isEmpty()) {
				int now = q.poll();

				if (now == B) {
					Stack<Character> s = new Stack<>();
					while (parent[now] != now) {
						s.push(path[now]);
						now = parent[now];
					}

					StringBuilder sb = new StringBuilder();
					while (!s.isEmpty()) {
						sb.append(s.pop());
					}
					System.out.println(sb);
					break;
				}
				int next = (now * 2) % 10000;
				if (parent[next] == -1) {
					parent[next] = now;
					path[next] = 'D';
					q.offer(next);
				}
				next = now == 0 ? 9999 : now - 1;
				if (parent[next] == -1) {
					parent[next] = now;
					path[next] = 'S';
					q.offer(next);
				}

				next = now / 1000 + (now % 1000) * 10;
				if (parent[next] == -1) {
					parent[next] = now;
					path[next] = 'L';
					q.offer(next);
				}
				next = now / 10 + now % 10 * 1000;
				if (parent[next] == -1) {
					parent[next] = now;
					path[next] = 'R';
					q.offer(next);
				}
			}
		} // end of TC
	}

}