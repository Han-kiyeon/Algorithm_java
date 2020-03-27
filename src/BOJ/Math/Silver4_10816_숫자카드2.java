package BOJ.Math;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Silver4_10816_숫자카드2.java
 *
 * @Date : 2020. 4. 2.
 * @작성자 : 한기연
 * @메모리 : 297116 kb
 * @실행시간 : 2164 ms
 *
 * @Blog : __
 **/
public class Silver4_10816_숫자카드2 {
	static int N;
	static int card[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		Arrays.sort(card);
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(check(sc.nextInt())).append(" ");
		}
		System.out.println(sb);
	}

	private static int check(int x) {
		int low = lower(x);
		int high = upper(x);
		return high - low + 1;
	}

	private static int upper(int x) {
		int s = 0, e = N;
		while (s < e) {
			int m = (s + e) >> 1;
			if (card[m] == x) {
				s = m + 1;
			} else if (card[m] > x) {
				e = m;
			} else
				s = m + 1;
		}
		return e;
	}

	private static int lower(int x) {
		int s = 0, e = N;
		while (s < e) {
			int m = (s + e) >> 1;
			if (card[m] == x) {
				e = m;
			} else if (card[m] > x) {
				e = m;
			} else
				s = m + 1;
		}
		return s + 1;
	}
}