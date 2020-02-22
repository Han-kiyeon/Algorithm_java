import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] visit = new int[100001];
		int[] path = new int[100001];
		
		Queue<Integer> q = new LinkedList<Integer>();
		visit[N] = 1;
		path[N] = N;
		q.offer(N);
		int next;
		
		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == K) {
				System.out.println(visit[cur] - 1);
				StringBuilder sb = new StringBuilder(cur + "");
				while (path[cur] != cur) {
					sb.insert(0, " ").insert(0, path[cur]);
					cur = path[cur];
				}
				System.out.println(sb);
				return;
			}

			next = cur << 1;
			if (next <= 100000 && visit[next] == 0) {
				visit[next] = visit[cur] + 1;
				path[next] = cur;
				q.offer(next);
			}

			next = cur + 1;
			if (next <= 100000 && visit[next] == 0) {
				visit[next] = visit[cur] + 1;
				path[next] = cur;
				q.offer(next);
			}

			next = cur - 1;
			if (next >= 0 && visit[next] == 0) {
				visit[next] = visit[cur] + 1;
				path[next] = cur;
				q.offer(next);
			}

		}

	}
}