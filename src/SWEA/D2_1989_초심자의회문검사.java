package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D2_1989_초심자의회문검사.java
 *
 * @Date : 2019. 7. 24.
 * @작성자 : 한기연
 * @메모리 : 20,264 kb
 * @실행시간 : 137 ms
 *
 * @Blog : __
 **/
public class D2_1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String s = sc.next();
			StringBuilder sb = new StringBuilder(s);
			String sr = sb.reverse().toString();
			System.out.print("#" + (i + 1) + " ");
			if (s.equals(sr))
				System.out.println("1");
			else
				System.out.println("0");
		}
		sc.close();
	}
}