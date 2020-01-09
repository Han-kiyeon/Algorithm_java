package SWEA.D3;

import java.util.Scanner;

/**
 * @FileName : Solution_5431_민석이의과제체크하기.java
 * @Project : Algorithm_java
 * @Date : 2019. 7. 16. 
 * @작성자 : 한기연
 * @메모리 : 56,744 kb
 * @실행시간 : 363 ms
 **/
public class Solution_5431_민석이의과제체크하기 {
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