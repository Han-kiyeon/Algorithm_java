package SWEA;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_7일차_D3_1225_암호생성기.java
 *
 * @Date : 2019. 8. 3.
 * @작성자 : 한기연
 * @메모리 : 28,996 kb
 * @실행시간 : 154 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_7일차_D3_1225_암호생성기 {
	private static Queue<Integer> queue;

	private static boolean cycle() {
		for (int i = 1; i <= 5; i++) {
			int tmp = queue.poll() - i;

			if (tmp <= 0) {
				queue.add(0);
				return false;
			} else
				queue.add(tmp);
			// System.out.println(queue);
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1225_D3_암호생성기.txt"));
		Scanner s = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			s.nextInt(); // tc

			queue = new LinkedList<>();
			for (int i = 0; i < 8; i++)
				queue.add(s.nextInt());

			// System.out.println(queue);

			while (cycle()) {
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++)
				System.out.print(queue.poll() + " ");
			System.out.println();
		}

		s.close();
	}
}