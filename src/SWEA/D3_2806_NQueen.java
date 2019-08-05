package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D3_2806_NQueen.java
 *
 * @Date : 2019. 8. 5.
 * @작성자 : 한기연
 * @메모리 : 33,356 kb
 * @실행시간 : 154 ms
 *
 * @Blog : __
 **/
public class D3_2806_NQueen {
	public static int N;
	public static int[] col;
	public static int result;

	public static void nqueen(int i) {
		if (i == N) {
//          for (int j = 0; j < N; j++) {
//              System.out.println("[ " + col[j] + ", " + j + "]");
//          }
//          System.out.println();
			result = result + 1;
		} else {
			for (int j = 0; j < N; j++) {
				col[i] = j;
				if (promising(i)) {
					nqueen(i + 1);
				}
			}
		}
	}

	public static boolean promising(int i) {
		for (int j = 0; j < i; j++) {
			if (col[j] == col[i] || Math.abs(col[i] - col[j]) == (i - j))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			result = 0;
			N = sc.nextInt();
			col = new int[N];
			nqueen(0);
			System.out.println("#" + (tc + 1) + " " + result);
		}
		sc.close();
	}
}