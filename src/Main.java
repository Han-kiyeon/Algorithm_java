import java.util.Scanner;

public class Main {
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