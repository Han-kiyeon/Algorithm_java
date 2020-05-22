import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, K, ans;
	static int[][] party;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] person = new int[N + 1];
		M = sc.nextInt();
		K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			person[sc.nextInt()] = 1;// 진실을 아는 사람들..
		}
		party = new int[M][];
		for (int i = 0; i < M; i++) {
			int tmp = sc.nextInt();
			party[i] = new int[tmp];
			for (int j = 0; j < tmp; j++) {
				party[i][j] = sc.nextInt();
			}
		}
		solve(0, 0, -1, person.clone());
		solve(0, 0, 1, person.clone());
		System.out.println(ans);
	}

	private static void solve(int depth, int cnt, int fact, int[] person) {
		if (depth == M) {
			if (ans < cnt)
				ans = cnt;
			return;
		}

		for (int i = 0; i < party[depth].length; i++) {
			int now = party[depth][i];
			if (person[now] != 0 && person[now] != fact) {
				return;
			}
			person[now] = fact;
		}

		if (fact == -1)
			cnt++;
		solve(depth + 1, cnt, -1, person.clone());
		solve(depth + 1, cnt, 1, person.clone());

	}
}