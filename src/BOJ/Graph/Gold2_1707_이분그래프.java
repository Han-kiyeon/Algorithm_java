package BOJ.Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gold2_1707_이분그래프 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		ArrayList<Integer>[] graph1 = new ArrayList[V];
		ArrayList<Integer>[] graph2 = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			graph1[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;
			graph1[s].add(e);
			graph2[e].add(s);
		}

		int ans = 0;
		for (int i = 0; i < V; i++) {
			boolean[] visit = new boolean[V];
			Queue<Integer> q = new LinkedList<>();
			visit[i] = true;
			q.add(i);

			while (!q.isEmpty()) {
				int now = q.poll();
				for (Integer next : graph1[now]) {
					if (!visit[next]) {
						visit[next] = true;
						q.add(next);
					}
				}
			}

			q.add(i);
			while (!q.isEmpty()) {
				int now = q.poll();
				for (Integer next : graph2[now]) {
					if (!visit[next]) {
						visit[next] = true;
						q.add(next);
					}
				}
			}
			boolean flag = true;
			for (int j = 0; j < visit.length && flag; j++) {
				if (!visit[j])
					flag = false;
			}
			if (flag)
				ans++;

		}
		System.out.println(ans);
	}
}