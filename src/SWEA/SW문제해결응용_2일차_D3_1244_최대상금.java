package SWEA;

import java.io.*;
import java.util.*;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결응용_2일차_D3_1244_최대상금.java
 *
 * @Date : 2019. 8. 19.
 * @작성자 : 한기연
 * @메모리 : 20,332 kb
 * @실행시간 : 3,696 ms
 *
 * @Blog : __
 **/
public class SW문제해결응용_2일차_D3_1244_최대상금 {
	public static int[] data;
	public static int N, result;

	public static void solve(int cur, int cnt) {
		if (cnt == N) {
			int tmp = 0, digit = 1;
			for (int i = data.length - 1; i >= 0; i--) {
				tmp += data[i] * digit;
				digit *= 10;
			}
			result = (result > tmp) ? result : tmp;
			return;
		}
		for (int i = cur; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {

				swap(i, j);
				// System.out.println((cnt + 1) + ": (" + i + ", " + j + ")" +
				// Arrays.toString(data));
				solve(i, cnt + 1);
				swap(i, j);

			}
		}
	}

	public static void swap(int a, int b) {
		int tmp = data[a];
		data[a] = data[b];
		data[b] = tmp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			N = Integer.parseInt(st.nextToken());

			data = new int[str.length()];

			for (int i = 0; i < data.length; i++) {
				data[i] = str.charAt(i) - '0';
			}
			// System.out.println(N + ">>>" + Arrays.toString(data));
			result = 0;
			solve(0, 0);
			System.out.println("#" + tc + " " + result);
		}

		br.close();
	}

}