package SWEA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_2일차_D3_1208_Flatten.java
 *
 * @Date : 2019. 7. 16.
 * @작성자 : 한기연
 * @메모리 : 23,404 kb
 * @실행시간 : 178 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_2일차_D3_1208_Flatten {
	public static void main(String args[]) throws Exception {

		// System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		Scanner s = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int Dump = s.nextInt(); // 834

			int[] box = new int[100];

			for (int i = 0; i < 100; i++) {
				box[i] = s.nextInt();
			}
			// System.out.println("원본 배열 = " + Arrays.toString(box));

			Arrays.sort(box);

			// System.out.println("정렬된 배열 = " + Arrays.toString(box));

			int head = 0;
			int tail = 99;
			while (true) {

				box[head]++;
				box[tail]--;
				Dump--;
				Arrays.sort(box);
				if (Dump == 0)
					break;
			}

			System.out.println("#" + tc + " " + (box[99] - box[0]));
		}
		s.close(); // Scanner close
	}
}