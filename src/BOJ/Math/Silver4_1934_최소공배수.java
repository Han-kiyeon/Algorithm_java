package BOJ.Math;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Silver4_1934_최소공배수.java
 *
 * @Date : 2020. 1. 24.
 * @작성자 : 한기연
 * @메모리 : 19660 kb
 * @실행시간 : 220 ms
 **/
		 
public class Silver4_1934_최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int tc = 0; tc < N; tc++) {
			int A, B;

			A = sc.nextInt();
			B = sc.nextInt();

			System.out.println(lcm(A, B));
		}
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

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}
