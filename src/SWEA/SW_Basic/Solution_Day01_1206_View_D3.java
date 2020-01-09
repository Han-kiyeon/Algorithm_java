package SWEA.SW_Basic;

import java.util.Scanner;

/**
 * @FileName : Solution_Day01_1206_View_D3.java
 * @Project : Algorithm_java
 * @Date : 2019. 7. 17.
 * @작성자 : 한기연
 * @메모리 : 54,536 kb
 * @실행시간 : 223 ms
 **/
public class Solution_Day01_1206_View_D3 {
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