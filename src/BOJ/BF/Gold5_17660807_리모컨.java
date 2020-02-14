package BOJ.BF;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold5_17660807_리모컨.java
 *
 * @Date : 2020. 2. 13.
 * @작성자 : 한기연
 * @메모리 : 109160 kb
 * @실행시간 : 384	 ms
 *
 * @Blog : __
 **/
public class Gold5_17660807_리모컨 {
	static boolean[] broken;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int start = 100;
		int goal = sc.nextInt();
		if (start == goal) {
			System.out.println(0);
			return;
		}
		int N = sc.nextInt();
		broken = new boolean[10];
		for (int i = 0; i < N; i++) {
			broken[sc.nextInt()] = true;
		}
		int ans = Math.abs(goal - start);
		for (int i = 0; i <= 1000000; i++) { // 숫자 버튼으로 이동하는 채널
			if (go(i)) {
				int tmp = Math.abs(i - goal) + ("" + i).length(); // +나 -를 몇 번 눌러야 하는지 계산
				if (ans > tmp) {
					ans = tmp;
				}
			}
		}
		System.out.println(ans);
	}

	private static boolean go(int x) {
		String str = "" + x;
		for (int i = 0; i < str.length(); i++) {
			if (broken[str.charAt(i) - '0'])
				return false;
		}
		return true;
	}
}
