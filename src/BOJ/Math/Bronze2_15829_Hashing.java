package BOJ.Math;
import java.util.Scanner;

public class Bronze2_15829_Hashing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		String str = sc.next();
		long r = 1;
		int mod = 1234567891;
		long H = 0;

		for (int i = 0; i < L; i++) {
			int now = str.charAt(i) - 'a' + 1;
			H += now * r;
			r *= 31;
			H %= mod;
			r %= mod;
		}

		System.out.println(H);
	}
}

