import java.util.ArrayList;
import java.util.Scanner;

class Main {
	static int N, M, ans;
	static ArrayList<Integer>[] graph;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			graph[s].add(e);
			graph[e].add(s);
		}
		ans = 0;
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			DFS(i, 1);
			if (ans == 1)
				break;
		}
		System.out.println(ans);
	}

	private static void DFS(int i, int depth) {
		if (depth == 5 || ans == 1) {
			ans = 1;
			return;
		}
		visit[i] = true;
		for (int j = 0; j < graph[i].size(); j++) {
			if (!visit[graph[i].get(j)]) {
				visit[graph[i].get(j)] = true;
				DFS(graph[i].get(j), depth + 1);
				visit[graph[i].get(j)] = false;
			}
		}
		visit[i] = false;
	}
}
