import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] rlt;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N];
		rlt = new int[M];
		solve(0);
	}

	private static void solve(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(rlt[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				rlt[depth] = i+1;
				solve(depth + 1);
				visit[i] = false;
			}
		}
	}
}