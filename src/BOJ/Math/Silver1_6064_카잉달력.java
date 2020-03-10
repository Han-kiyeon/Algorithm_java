package BOJ.Math;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Silver1_6064_카잉달력.java
 *
 * @Date : 2020. 3. 10.
 * @작성자 : 한기연
 * @메모리 : 23080 kb
 * @실행시간 : 352 ms
 *
 * @Blog : __
 **/

public class Silver1_6064_카잉달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int year = x;
			int max = lcm(M, N);

			while (true) {
				if (year > max) {
					System.out.println("-1");
					break;
				} else if (((year % N) == 0 ? N : year % N) == y) {
					System.out.println(year);
					break;
				}
				year += M;
			}
		}
	}

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}