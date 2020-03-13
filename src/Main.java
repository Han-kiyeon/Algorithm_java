import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, ans;

	static int[] col;
	static boolean[] slash, backslash;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		col = new int[N];
		Arrays.fill(col, -1);
		slash = new boolean[2 * N - 1];
		backslash = new boolean[2 * N - 1];

		ans = 0;
		solve(0);
		System.out.println(ans);
	}

	public static void solve(int r) {
		if (r == N) {
			System.out.println(Arrays.toString(col));

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (col[j] == i)
						System.out.print(1 + " ");
					else
						System.out.print(0 + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			ans++;
			//return;
			System.exit(0);
		}
		for (int c = 0; c < N; c++) {
			if (check(r, c)) {
				col[c] = r;
				slash[r + c] = backslash[r - c + N - 1] = true;
				solve(r + 1);
				col[c] = -1;
				slash[r + c] = backslash[r - c + N - 1] = false;
			}
		}
	}

	public static boolean check(int r, int c) {
		if (col[c] != -1 || slash[r + c] || backslash[r - c + N - 1])
			return false;
		return true;
	}
}
