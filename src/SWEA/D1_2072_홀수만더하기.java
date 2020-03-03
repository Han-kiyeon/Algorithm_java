package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D1_2072_홀수만더하기.java
 *
 * @Date : 2019. 8. 20.
 * @작성자 : 한기연
 * @메모리 : 18,972 kb
 * @실행시간 : 113 ms
 *
 * @Blog : __
 **/
public class D1_2072_홀수만더하기 {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/D1_2072_홀수만더하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp % 2 != 0)
					sum += tmp;
			}
			System.out.println("#" + tc + " " + sum);
		}

		br.close();
	}
}
