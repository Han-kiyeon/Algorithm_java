package SWEA.D1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @FileName : Solution_2063_중간값찾기.java
 * @Project : Algorithm_java
 * @Date : 2019. 7. 15.
 * @작성자 : 한기연
 * @메모리 : 20,780 kb
 * @실행시간 : 153 ms
 **/
public class Solution_2063_중간값찾기 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] gradeArr = new int[T];

		for (int tc = 0; tc < T; tc++) {
			gradeArr[tc] = sc.nextInt();
		}
		Arrays.sort(gradeArr);
		System.out.println(gradeArr[T / 2]);
	}
}