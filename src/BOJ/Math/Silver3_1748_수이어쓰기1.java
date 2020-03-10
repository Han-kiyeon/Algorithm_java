package BOJ.Math;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Silver3_1748_수이어쓰기1.java
 *
 * @Date : 2020. 3. 10.
 * @작성자 : 한기연
 * @메모리 : 14276 kb
 * @실행시간 : 112 ms
 *
 * @Blog : __
 **/
public class Silver3_1748_수이어쓰기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// N(1≤N≤100,000,000)
		int len = ("" + N).length();
		int ans = 0;
		int tmp = 9;
		for (int i = 1; i < len; i++) {
			ans += i * tmp;
			tmp *= 10;
		}
		ans += len * (N - (int) Math.pow(10, len - 1) + 1);
		System.out.println(ans);
	}
}