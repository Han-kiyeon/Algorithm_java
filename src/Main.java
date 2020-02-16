import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] rlt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		rlt = new int[M];
		solve(0, 0);
		System.out.println(sb);
	}

	private static void solve(int index, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(rlt[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			rlt[depth] = i + 1;
			solve(i, depth + 1);
		}

	}
}