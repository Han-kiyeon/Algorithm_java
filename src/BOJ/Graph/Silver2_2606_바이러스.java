package BOJ.Graph;
import java.util.Scanner;

public class Silver2_2606_바이러스 {
	static int V, E;

	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			union(sc.nextInt() - 1, sc.nextInt() - 1);
		}

		int ans = 0;
		for (int i = 0; i < V; i++) {
			if (find(i) == 0)
				ans++;
		}
		System.out.println(ans - 1);
	}

	private static void union(int i, int j) {
		int x = find(i);
		int y = find(j);

		if (x != y) {
			if (x < y)
				parent[y] = x;
			else
				parent[x] = y;
		}
	}

	private static int find(int i) {
		if (i == parent[i])
			return i;
		return parent[i] = find(parent[i]);
	}
}