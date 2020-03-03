package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D2_1959_두개의숫자열.java
 *
 * @Date : 2019. 7. 23.
 * @작성자 : 한기연
 * @메모리 : 20,796 kb
 * @실행시간 : 153 ms
 *
 * @Blog : __
 **/
public class D2_1959_두개의숫자열 {

	public static int[] data;

	public static int solve(int[] arrN, int[] arrM) {

		int N = arrN.length;
		int M = arrM.length;

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < M - N + 1; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += arrN[j] * arrM[j + i];
			}
			if (sum > max)
				max = sum;
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input_d2_1959.txt"));
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();// 테스트 케이스 개수 입력
		int N, M;
		int[] arrN;
		int[] arrM;
		for (int tc = 1; tc <= T; tc++) {

			N = s.nextInt();
			M = s.nextInt();

			arrN = new int[N];
			for (int i = 0; i < N; i++)
				arrN[i] = s.nextInt();

			arrM = new int[M];
			for (int i = 0; i < M; i++)
				arrM[i] = s.nextInt();

			int ans = 0;
			if (N < M)
				ans = solve(arrN, arrM);
			else
				ans = solve(arrM, arrN);

			System.out.println("#" + tc + " " + ans);
		}
		s.close();
	}
}