package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.d3
 * @FileName : SW문제해결기본_4일차_D3_1217_거듭제곱.java
 *
 * @Date : 2019. 7. 29.
 * @작성자 : 한기연
 * @메모리 : 26,500 kb
 * @실행시간 : 140 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_4일차_D4_1217_괄호짝짓기 {

	public static int pow(int a, int b) {// a^b
		if (b == 1)
			return a;
		else
			return a * pow(a, b - 1);
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/1217_D3_거듭제곱.txt"));
		Scanner s = new Scanner(System.in);

		int T = 10; // 10개의 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			s.nextInt(); // tc

			System.out.println("#" + tc + " " + pow(s.nextInt(), s.nextInt()));
		}

		s.close(); // Scanner close
	}
}
