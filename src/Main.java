import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, ret;
	static boolean[] visit;
	static int[] data, perm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		data = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}

		perm = new int[N];
		visit = new boolean[N];
		ret = 0;
		solve(0);
		System.out.println(ret);
	}

	private static void solve(int depth) {
		if (depth == N) {
			int sum = 0;
			//System.out.println(Arrays.toString(combi));
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(perm[i] - perm[i + 1]);
			}
			if (ret < sum)
				ret = sum;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				perm[depth] = data[i];
				solve(depth + 1);
				visit[i] = false;
			}
		}
	}
}