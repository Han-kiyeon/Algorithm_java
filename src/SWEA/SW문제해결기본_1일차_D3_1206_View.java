package SWEA;

import java.util.*;
import java.io.*;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_1일차_D3_1206_View.java
 *
 * @Date : 2019. 8. 26.
 * @작성자 : 한기연
 * @메모리 : 54,536 kb
 * @실행시간 : 223 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_1일차_D3_1206_View {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int N = s.nextInt();
			int[] ba = new int[N]; // BuildingArr

			for (int i = 0; i < N; i++)
				ba[i] = s.nextInt();

			int cnt = 0;

			for (int i = 2; i < N - 2; i++) {
				for (int j = 1; j < ba[i] + 1; j++) {
					if ((ba[i - 2] < j) && (ba[i - 1] < j) && (ba[i + 1] < j) && (ba[i + 2] < j))
						cnt++;
				}
			}
			System.out.println("#" + (tc + 1) + " " + cnt);
		}

		s.close(); // Scanner close
	}
}