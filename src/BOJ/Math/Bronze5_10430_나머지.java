package BOJ.Math;

import java.util.Scanner;


/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Bronze5_10430_나머지.java
 *
 * @Date : 2020. 1. 24.
 * @작성자 : 한기연
 * @메모리 : __ kb
 * @실행시간 : __ ms
 **/
public class Bronze5_10430_나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A, B, C;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		System.out.println((A + B) % C);
		System.out.println((A % C + B % C) % C);
		System.out.println((A * B) % C);
		System.out.println((A % C * B % C) % C);

		sc.close();
	}
}
