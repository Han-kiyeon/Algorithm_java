package BOJ.BF;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver1_14888_연산자끼워넣기.java
 *
 * @Date : 2020. 1. 26.
 * @작성자 : 한기연
 * @메모리 : 15648 kb
 * @실행시간 : 120 ms
 **/

public class Silver1_14888_연산자끼워넣기 {
	static int N, max, min;
	static int[] data, op, ret;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		data = new int[N];
		for (int i = 0; i < N; i++)
			data[i] = sc.nextInt();

		op = new int[4];
		for (int i = 0; i < 4; i++)
			op[i] = sc.nextInt();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		ret = new int[N - 1];
		
		solve(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void solve(int depth) {
		if (depth == N - 1) {
			int clac = data[0];
			for (int i = 0; i < N - 1; i++) {
				switch (ret[i]) {
				case 0:
					clac += data[i + 1];
					break;
				case 1:
					clac -= data[i + 1];
					break;
				case 2:
					clac *= data[i + 1];
					break;
				case 3:
					clac /= data[i + 1];
					break;
				}
			}
			if (max < clac)
				max = clac;
			if (min > clac)
				min = clac;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				ret[depth] = i;
				solve(depth + 1);
				op[i]++;
			}
		}
	}
}