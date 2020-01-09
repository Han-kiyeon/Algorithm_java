package SWEA.SW_Basic;

import java.util.Scanner;

/**
 * @FileName : Solution_Day01_1204_최빈수구하기_D2.java
 * @Project : Algorithm_java
 * @Date : 2019. 7. 16.
 * @작성자 : 한기연
 * @메모리 : 36,640 kb
 * @실행시간 : 204 ms
 **/
public class Solution_Day01_1204_최빈수구하기_D2 {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		for (int i = 1; i <= N; i++) {
			int num = s.nextInt();
			int[] array = new int[1000];

			for (int j = 0; j < 1000; j++) {
				array[j] = s.nextInt();
			}

			int[] countarray = new int[101];

			for (int j = 0; j < 1000; j++) {
				countarray[array[j]]++;
			}

			int result = 0;
			int temp = 0;

			for (int j = 100; j >= 0; j--) {
				if (result < countarray[j]) {
					result = countarray[j];
					temp = j;
				}
			}

			System.out.println("#" + num + " " + temp);

		}

	}

}