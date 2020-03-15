package BOJ.BF;
import java.util.Scanner;

public class Silver3_2003_수들의합2_ver2 {

	static int N, M, ans, sum;
	static int[] data;
	static int s, e;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		data = new int[N + 1];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		s = 0;
		e = 0;

		while (e <= N) {
			if (sum == M)
				ans++;

			if (sum < M)
				sum += data[e++];
			else
				sum -= data[s++];
		}

		System.out.println(ans);

	}

}
