package SWEA.문제해결_기본;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.문제해결_기본
 * @FileName : Day01_1206_View.java
 *
 * @Date : 2020. 6. 17.
 * @작성자 : 한기연
 * @메모리 : 37,200 kb
 * @실행시간 : 182 ms
 *
 * @Blog : https://herong.tistory.com/entry/SWEA-1206-SW-%EB%AC%B8%EC%A0%9C%ED%95%B4%EA%B2%B0-%EA%B8%B0%EB%B3%B8-1%EC%9D%BC%EC%B0%A8-View-D3-Java
 **/
public class Day01_1206_View {
	static int N;
	static int[] building;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 가로 길이
			building = new int[N];
			for (int i = 0; i < N; i++) {
				building[i] = sc.nextInt();
			}

			int cnt = 0;
			for (int i = 2; i < N - 2; i++) {
				int max = Math.max(building[i - 2], Math.max(building[i - 1], Math.max(building[i + 1], building[i + 2])));
				if (building[i] - max > 0)
					cnt += building[i] - max;
			}

			System.out.println("#" + tc + " " + cnt);
		} // end of TC
	} // end of Main
}