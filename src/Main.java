import java.util.Scanner;

public class Main {
	static int N;
	static int[] data;
	static boolean[] visit;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		data = new int[N];
		visit = new boolean[N];
		solve(0, 0);
	}

	private static void solve(int idx, int depth) {
		if (depth == N) {
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				data[depth] = i + 1;
				solve(i, depth + 1);
				visit[i] = false;
			}
		}

	}
}