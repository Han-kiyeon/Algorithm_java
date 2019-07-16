package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D3_5431_민석이의과제체크하기.java
 *
 * @Date : 2019. 7. 16.
 * @작성자 : 한기연
 * @메모리 : 56,744 kb
 * @실행시간 : 363 ms
 *
 * @Blog : __
 **/
public class D3_5431_민석이의과제체크하기 {
	public static void main(String args[]) throws Exception {

		// System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		for (int i = 0; i < N; i++) {

			int students = s.nextInt();
			int submit = s.nextInt();

			int[] mem = new int[students];

			for (int j = 0; j < submit; j++) {
				int temp = s.nextInt();
				mem[temp - 1]++;
			}
			System.out.print("#" + (i + 1) + " ");

			for (int j = 0; j < students; j++) {
				if (mem[j] == 0)
					System.out.print((j + 1) + " ");
			}
			System.out.println();

		}

		s.close(); // Scanner close
	}
}