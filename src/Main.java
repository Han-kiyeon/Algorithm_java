import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
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
		for (int i = 0; i <= 1000000; i++) {
			if (go(i)) {
				int tmp = Math.abs(i - goal) + ("" + i).length();
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
