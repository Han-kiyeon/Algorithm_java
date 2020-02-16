package BOJ.BF;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Silver5_11723_집합.java
 *
 * @Date : 2020. 2. 16.
 * @작성자 : 한기연
 * @메모리 : 389,056 kb
 * @실행시간 : 3,632 ms
 *
 * @Blog : __
 **/

public class Silver5_11723_집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();

		int M = sc.nextInt();
		boolean[] set = new boolean[21];
		for (int i = 0; i < M; i++) {
			switch (sc.next()) {
			case "add":
				set[sc.nextInt()] = true;
				break;
			case "remove":
				set[sc.nextInt()] = false;
				break;
			case "check":
				if (set[sc.nextInt()])
					ans.append("1\n");
				else
					ans.append("0\n");
				break;
			case "toggle":
				int tmp = sc.nextInt();
				set[tmp] = !set[tmp];
				break;
			case "all":
				Arrays.fill(set, true);
				break;
			case "empty":
				Arrays.fill(set, false);
				break;
			}
		}
		 System.out.println(ans);
	}
}
