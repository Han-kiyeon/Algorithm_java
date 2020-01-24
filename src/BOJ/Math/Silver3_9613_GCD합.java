package BOJ.Math;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Silver3_9613_GCD합.java
 *
 * @Date : 2020. 1. 24.
 * @작성자 : 한기연
 * @메모리 : 14360 kb
 * @실행시간 : 116 ms
 **/

public class Silver3_9613_GCD합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			long ans = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					ans += gcd(arr[i], arr[j]);
				}
			}
			System.out.println(ans);

		} // End of TC
		sc.close();
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
