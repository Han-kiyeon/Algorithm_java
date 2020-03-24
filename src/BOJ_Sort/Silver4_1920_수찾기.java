package BOJ_Sort;
import java.util.Arrays;
import java.util.Scanner;

public class Silver4_1920_수찾기 {
	static int N;
	static int[] data;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		data = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}

		Arrays.sort(data);

		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			if (find(sc.nextInt()))
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.println(sb);
	}

	private static boolean find(int x) {
		int s = 0, e = N, m = 0;
		while (s < e) {
			m = (s + e) >> 1;
			if (data[m] == x)
				return true;
			else if (data[m] > x) {
				e = m;
			} else {
				s = m + 1;
			}
		}

		return false;
	}
}