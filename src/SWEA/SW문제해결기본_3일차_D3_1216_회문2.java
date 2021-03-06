package SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_3일차_D3_1216_회문2.java
 *
 * @Date : 2019. 7. 23.
 * @작성자 : 한기연
 * @메모리 : 41,540 kb
 * @실행시간 : 264 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_3일차_D3_1216_회문2 {

	public static char[][] matrix = new char[100][100];

	public static boolean solve(int a) {
		int head, tail;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <= matrix[i].length - a; j++) {
				// 가로 탐색
				head = 0;
				tail = a - 1;
				while (head <= tail) {
					if (matrix[i][j + head] == matrix[i][j + tail]) {
						head++;
						tail--;
					} else
						break;
				}
				if (head > tail) {
					return true;
				}
			}
		}

		for (int i = 0; i <= matrix.length - a; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// 가로 탐색
				head = 0;
				tail = a - 1;
				while (head <= tail) {
					if (matrix[i + head][j] == matrix[i + tail][j]) {
						head++;
						tail--;
					} else
						break;
				}
				if (head > tail) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1216_D3_회문2.txt"));
		Scanner s = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {

			s.nextInt();

			for (int i = 0; i < 100; i++) {
				char[] row = s.next().toCharArray();
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = row[j];
				}
			}

//			for(char[] b :matrix)
//				System.out.println(Arrays.toString(b));

			int ans = -1;
			for (int i = 1; i <= 100; i++)
				if (solve(i))
					ans = i;

			System.out.println("#" + tc + " " + ans);
		}

		s.close(); // Scanner close
	}
}
