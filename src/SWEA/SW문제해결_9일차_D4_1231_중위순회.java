package SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결_9일차_D4_1231_중위순회.java
 *
 * @Date : 2019. 8. 4.
 * @작성자 : 한기연
 * @메모리 : 30,872 kb
 * @실행시간 : 159 ms
 *
 * @Blog : __
 **/
public class SW문제해결_9일차_D4_1231_중위순회 {
	static char[] arr;
	static int N;

	private static void solve(int i) {
		if (check(i * 2))// 왼쪽 순회
			solve(i * 2);

		System.out.print(arr[i]); // 자신

		if (check(i * 2 + 1)) // 오른쪽 순회
			solve(i * 2 + 1);
	}

	private static boolean check(int x) {
		if (1 <= x && x <= N)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1231_D3_중위순회.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10; // 10개의 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt(); // 8 입력
			arr = new char[N + 1];

			for (int i = 1; i <= N; i++) {
				boolean flag = true;
				while (flag) {
					char c = sc.next().charAt(0);
					if (!('0' <= c && c <= '9')) {
						arr[i] = c;
						flag = false;
					}
				}
			}

			solve(1);
			System.out.println();

		}

		sc.close();
	}
}