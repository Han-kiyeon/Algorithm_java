import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < M; i++) {
			pq.offer(new int[] { sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() });
		}

		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		int ans = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();

			int a = find(now[0]);
			int b = find(now[1]);

			if (a == b)
				continue;

			union(a, b);
			ans += now[2];
		}
		System.out.println(ans);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			if (x < y)
				parent[y] = x;
			else
				parent[x] = y;
		}
	}

	private static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}
}