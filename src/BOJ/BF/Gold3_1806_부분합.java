package BOJ.BF;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold3_1806_부분합.java
 *
 * @Date : 2020. 3. 15.
 * @작성자 : 한기연
 * @메모리 : 90640 kb
 * @실행시간 : 684 ms
 *
 * @Blog : __
 **/
public class Gold3_1806_부분합 {

	static int N, S, ans, sum;
	static int[] data;
	static int s, e;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();

		data = new int[N + 1];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}

		ans = Integer.MAX_VALUE;
		s = 0;
		e = 0;
		while (e <= N && s <= N) {
			if (sum >= S && ans > e - s)
				ans = e - s;

			if (sum < S)
				sum += data[e++];
			else
				sum -= data[s++];
		}
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}