package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver5_1476_날짜계산.java
 *
 * @Date : 2020. 1. 25.
 * @작성자 : 한기연
 * @메모리 : 14248 kb
 * @실행시간 : 104 ms
 **/

public class Silver5_1476_날짜계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int E, S, M;
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();

		int year = 1;

		while (true) {
			if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0)
				break;
			year++;
		}

		System.out.println(year);
	}
}