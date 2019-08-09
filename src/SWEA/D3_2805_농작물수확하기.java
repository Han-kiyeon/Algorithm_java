package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D3_2805_농작물수확하기.java
 *
 * @Date : 2019 .8 .9
 * @작성자 : 한기연
 * @메모리 : 35,188 kb
 * @실행시간 : 182 ms
 *
 * @Blog : __
 **/
public class D3_2805_농작물수확하기 {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < N; j++)
					farm[i][j] = tmp.charAt(j) - '0';
			}
			// for (int[] c : farm)
			// System.out.println(Arrays.toString(c));
			// System.out.println();

			for (int i = 0; i < N; i++) {// 행
				for (int j = 0; j < N; j++) {// 열
					if (i <= N / 2) {
						if (Math.abs(N / 2 - i) >= j + 1)
							farm[i][j] = 0;
						if (Math.abs(N / 2 - i) >= N - j)
							farm[i][j] = 0;
					} else {
						if (Math.abs(N / 2 - i) >= j + 1)
							farm[i][j] = 0;
						if (Math.abs(N / 2 - i) >= N - j)
							farm[i][j] = 0;
					}
				}
			}

			int sum = 0;
			for (int i = 0; i < N; i++) {// 행
				for (int j = 0; j < N; j++) {// 열
					sum += farm[i][j];
				}
			}

			// for (int[] c : farm)
			// System.out.println(Arrays.toString(c));

			System.out.println("#" + tc + " " + sum);

		}
	}

}