package BOJ.BF;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver2_2529_부등호.java
 *
 * @Date : 2020. 3. 10.
 * @작성자 : 한기연
 * @메모리 : 23452 kb
 * @실행시간 : 508 ms
 *
 * @Blog : __
 **/
public class Silver2_2529_부등호 {
	static int K;
	static long min, max;
	static char[] op;
	static int[] data;
	static boolean[] visit;
	static String minValue, maxValue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); // 2 ≤ k ≤ 9

		op = new char[K];
		for (int i = 0; i < K; i++) {
			op[i] = sc.next().charAt(0);
		}

		data = new int[K + 1];
		visit = new boolean[10];
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		solve(0, 0);
		System.out.println(maxValue);
		System.out.println(minValue);
	}

	private static void solve(int index, int depth) {
		if (depth == data.length) {
			check();
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!visit[i]) {
				visit[i] = true;
				data[depth] = i;
				solve(index, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static void check() {
		for (int i = 0; i < op.length; i++) {
			switch (op[i]) {
			case '<':
				if (data[i] >= data[i + 1]) {
					return;
				}
				break;
			case '>':
				if (data[i] <= data[i + 1]) {
					return;
				}
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(data[i]);
		}
		long ret = Long.parseLong(sb.toString());
		if (min > ret) {
			min = ret;
			minValue = sb.toString();
		}
		if (max < ret) {
			max = ret;
			maxValue = sb.toString();
		}
	}
}