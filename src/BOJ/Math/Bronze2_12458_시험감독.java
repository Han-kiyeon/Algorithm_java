package BOJ.Math;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Bronze2_12458_시험감독.java
 *
 * @Date : 2020. 5. 6.
 * @작성자 : 한기연
 * @메모리 : 291176 kb
 * @실행시간 : 1476 ms
 *
 * @Blog : __
 **/
public class Bronze2_12458_시험감독 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] map = new int[N];

		for (int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();

		long ans = 0;
		for (int i = 0; i < N; i++) {
			map[i] -= B;
			ans++;
			if (map[i] <= 0)
				continue;
			ans += map[i] / C + 1;
			if (map[i] % C == 0)
				ans--;
		}
		System.out.println(ans);
	}
}