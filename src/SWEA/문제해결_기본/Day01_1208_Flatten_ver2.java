package SWEA.문제해결_기본;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.문제해결_기본
 * @FileName : Day01_1208_Flatten_ver2.java
 *
 * @Date : 2020. 6. 19.
 * @작성자 : 한기연
 * @메모리 : 24,444 kb
 * @실행시간 : 160 ms
 *
 * @Blog : __
 **/

public class Day01_1208_Flatten_ver2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int dump = sc.nextInt();
			int[] map = new int[101];
			int max = 1;
			int min = 100;
			for (int i = 0; i < 100; i++) {
				int tmp = sc.nextInt();
				map[tmp]++;
				max = Math.max(max, tmp);
				min = Math.min(min, tmp);
			}
			for (int i = 0; i < dump; i++) {
				map[min]--;
				map[min + 1]++;

				map[max]--;
				map[max - 1]++;

				while (map[min] == 0) {
					min++;
				}

				while (map[max] == 0) {
					max--;
				}
			}

			System.out.println("#" + tc + " " + (max - min));
		} // end of TC
	}// end of Main
}