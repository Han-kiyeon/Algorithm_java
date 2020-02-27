import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		boolean visit[][] = new boolean[S + 1][S + 1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 1, 0, 0 });
		visit[1][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (now[0] == S) {
				System.out.println(now[2]);
				return;
			}
			// 복사
			int next = now[0];
			if (!visit[next][now[0]]) {
				visit[next][now[0]] = true;
				q.add(new int[] { next, now[0], now[2] + 1 });
			}
			// 붙여넣기
			next = now[0] + now[1];
			if (next <= S && !visit[next][now[1]]) {
				visit[next][now[1]] = true;
				q.add(new int[] { next, now[1], now[2] + 1 });
			}
			// 지우기
			next = now[0] - 1;
			if (next > 0 && !visit[next][now[1]]) {
				visit[next][now[1]] = true;
				q.add(new int[] { next, now[1], now[2] + 1 });
			}
		}
	}
}
