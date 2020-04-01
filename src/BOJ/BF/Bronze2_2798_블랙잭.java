package BOJ.BF;
import java.util.Scanner;

public class Bronze2_2798_블랙잭 {
	static int N, M, ans;
	static int[] card;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		card = new int[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		ans = -1;
		solve(0, 0, 0);
		System.out.println(ans);
	}

	private static void solve(int index, int depth, int sum) {
		if (depth == 3) {
			if (sum <= M && ans < sum)
				ans = sum;
			return;
		}
		for (int i = index; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				solve(i, depth + 1, sum + card[i]);
				visit[i] = false;
			}
		}

	}
}