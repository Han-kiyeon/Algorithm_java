import java.util.Scanner;

public class Main {
	static int K;
	static int[] S, data;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			K = sc.nextInt();
			if (K == 0)
				return;

			S = new int[K];
			for (int i = 0; i < K; i++) {
				S[i] = sc.nextInt();
			}

			visit = new boolean[K];
			data = new int[6];
			solve(0, 0);
			System.out.println();
		}
	}

	private static void solve(int idx, int depth) {
		if (depth == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = idx; i < K; i++) {
			if (!visit[i]) {
				visit[i] = true;
				data[depth] = S[i];
				solve(i, depth + 1);
				visit[i] = false;
			}
		}
	}
}