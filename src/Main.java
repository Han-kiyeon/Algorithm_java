import java.util.Scanner;

public class Main {
	static int N, ans;
	static int[][] data;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		data = new int[2][N];

		for (int i = 0; i < N; i++) {
			data[0][i] = sc.nextInt();
			data[1][i] = sc.nextInt();
		}
		visit = new boolean[N];
		ans = 0;
		for (int i = 1; i <= N; i++) {
			solve(i, 0, 0);
		}
		System.out.println(ans);
	}

	private static void solve(int n, int index, int depth) {
		if (depth == n) {
			check();
			return;
		}
		for (int i = index; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				solve(n, i, depth + 1);
				visit[i] = false;
			}
		}

	}

	private static void check() {
		boolean[] tmp = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				int end = i + data[0][i];
				if (end > N)
					return;
				for (int j = i; j < end; j++) {
					if (tmp[j])
						return;
					tmp[j] = true;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (visit[i])
				sum += data[1][i];
		}
		if (ans < sum)
			ans = sum;
	}
}