package SWEA.문제해결_기본;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.문제해결_기본
 * @FileName : Day01_1208_Flatten_ver1.java
 *
 * @Date : 2020. 6. 19.
 * @작성자 : 한기연
 * @메모리 : 24,804 kb
 * @실행시간 : 179 ms
 *
 * @Blog : __
 **/

public class Day01_1208_Flatten_ver1 {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int N = 100;
		for (int tc = 1; tc <= T; tc++) {
			int dump = sc.nextInt();
			int[] map = new int[N];
			for (int i = 0; i < N; i++) {
				map[i] = sc.nextInt();
			}
			for (int i = 0; i < dump; i++) {
				Arrays.sort(map);
				map[0]++;
				map[99]--;
			}
			
			Arrays.sort(map);
			System.out.println("#" + tc + " " + (map[99] - map[0]));
		} // end of TC
	}// end of Main
}