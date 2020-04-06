package BOJ.DFS_BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Silver1_12852_1로만들기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();

		int[] path = new int[X + 1];
		Queue<int[]> q = new LinkedList<>();

		path[X] = X;
		q.offer(new int[] { X, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (now[0] == 1) {
				System.out.println(now[1]);
				int next = now[0];
				Stack<Integer> s = new Stack<>();
				while (next != X) {
					s.push(next);
					next = path[next];
				}
				s.push(next);

				while (!s.isEmpty()) {
					System.out.print(s.pop()+" ");
				}
				System.out.println();
				return;
			}

			int next = 0;
			if (now[0] % 2 == 0) {
				next = now[0] / 2;
				if (path[next] == 0) {
					q.offer(new int[] { next, now[1] + 1 });
					path[next] = now[0];
				}
			}

			if (now[0] % 3 == 0) {
				next = now[0] / 3;
				if (path[next] == 0) {
					q.offer(new int[] { next, now[1] + 1 });
					path[next] = now[0];
				}
			}

			next = now[0] - 1;
			if (path[next] == 0) {
				q.offer(new int[] { next, now[1] + 1 });
				path[next] = now[0];
			}

		}
	}
}