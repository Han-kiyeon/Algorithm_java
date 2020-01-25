package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver3_9095_123더하기.java
 *
 * @Date : 2020. 1. 25.
 * @작성자 : 한기연
 * @메모리 : 14244 kb
 * @실행시간 : 108 ms
 **/

public class Silver3_9095_123더하기 {
	static int data, rlt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			data = sc.nextInt();
			rlt = 0;
			DFS(0);
			System.out.println(rlt);
		}
	}

	private static void DFS(int x) {
		if (x == data) {
			rlt++;
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if ((x + i) <= data)
				DFS(x + i);
		}
	}
}