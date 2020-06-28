package SWEA.문제해결_기본;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.문제해결_기본
 * @FileName : Day03_1213_String.java
 *
 * @Date : 2020. 6. 29.
 * @작성자 : 한기연
 * @메모리 : 22,332 kb
 * @실행시간 : 151 ms
 *
 * @Blog : __
 **/
public class Day03_1213_String {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sc.next();// 테스트케이스
			String pattern = sc.next();
			String text = sc.next();
			System.out.println("#" + tc + " " + KMP(text, pattern));
		} // end of TC 
	}// end of main

	private static int KMP(String text, String pattern) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] pi = getPi(pattern);
		int n = text.length();
		int m = pattern.length();

		char[] s = text.toCharArray();
		char[] p = pattern.toCharArray();

		for (int i = 0, j = 0; i < n; i++) {
			while (j > 0 && s[i] != p[j]) {
				j = pi[j - 1];
			}
			if (s[i] == p[j]) {
				if (j == m - 1) {
					list.add(i - m + 1);
					j = pi[j];
				} else
					j++;
			}
		}
		return list.size();
	}

	private static int[] getPi(String pattern) {
		char[] p = pattern.toCharArray();

		int m = pattern.length();
		int[] pi = new int[m];

		for (int i = 1, j = 0; i < m; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}