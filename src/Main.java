import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, ans;
	static int[] person;
	static boolean[] group;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		person = new int[N];
		for (int i = 0; i < N; i++) {
			person[i] = sc.nextInt();
		}

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			int K = sc.nextInt();
			for (int j = 0; j < K; j++) {
				int now = sc.nextInt() - 1;
				map[i][now] = map[now][i] = 1;
			}
		}
		group = new boolean[N];
		ans = Integer.MAX_VALUE;
		solve(0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	private static void solve(int depth) {
		if (depth == N) {
			int T = -1;
			int F = -1;
			for (int i = 0; i < group.length; i++) {
				if (F != -1 && T != -1)
					break;
				if (group[i])
					T = i;
				else
					F = i;
			}
			if (T == -1 || F == -1)
				return;

			if (check(T, F)) {
				int now = get();
				if (now < ans)
					ans = now;
			}
			return;
		}

		group[depth] = true;
		solve(depth + 1);
		group[depth] = false;
		solve(depth + 1);

	}

	private static int get() {
		int T = 0, F = 0;
		for (int i = 0; i < N; i++) {
			if (group[i])
				T += person[i];
			else
				F += person[i];
		}
		return Math.abs(T - F);
	}

	private static boolean check(int t, int f) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N];

		q.add(t);
		visit[t] = true;

		while (!q.isEmpty()) {
			int i = q.poll();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[j] && group[j]) {
					visit[j] = true;
					q.add(j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (group[i] != visit[i])
				return false;
		}

		q.clear();
		Arrays.fill(visit, false);

		q.add(f);
		visit[f] = true;

		while (!q.isEmpty()) {
			int i = q.poll();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[j] && !group[j]) {
					visit[j] = true;
					q.add(j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (group[i] == visit[i])
				return false;
		}
		return true;
	}
}