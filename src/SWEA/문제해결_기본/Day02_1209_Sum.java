package SWEA.문제해결_기본;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.문제해결_기본
 * @FileName : Day02_1209_Sum.java
 *
 * @Date : 2020. 6. 28.
 * @작성자 : 한기연
 * @메모리 : 95,112 kb
 * @실행시간 : 360 ms
 *
 * @Blog : __
 **/
public class Day02_1209_Sum {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sc.next(); // 테스트케이스 번호
			int[] sum = new int[202];// 0~99 >> 가로, 100~199 >> 세로 200,201 >> 대각선
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					int input = sc.nextInt();
					sum[i] += input;
					sum[j + 100] += input;
					if (i == j)
						sum[200] += input;
					if ((99 - i) == j)
						sum[201] += input;
				}
			}
			Arrays.sort(sum);
			System.out.println("#" + tc + " " + sum[201]);
		} // end of TC
	}// end of Main
}