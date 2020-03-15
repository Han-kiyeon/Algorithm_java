package BOJ.BF;
import java.util.Arrays;
import java.util.Scanner;

public class Silver3_2003_수들의합2_ver1 {
	static int N, M, ans;
	static int[] data;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}

		ans = 0;
		for (int i = 1; i <= N; i++) {
			solve(i);
		}
		System.out.println(ans);
	}

	private static void solve(int size) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += data[i];
		}

		for (int i = size; i < N; i++) {
			if (sum == M)
				ans++;
			sum += data[i];
			sum -= data[i - size];
		}
		if (sum == M)
			ans++;
	}
}