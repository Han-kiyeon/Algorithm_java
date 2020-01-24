import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (isPrimeNum(sc.nextInt()))
				ans++;
		}
		System.out.println(ans);

		sc.close();
	}

	private static boolean isPrimeNum(int x) {
		if (x == 1)
			return false; //1은 소수가 아님
		else if (x == 2)
			return true; //2는 소수

		for (int i = 2; i < x; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}
}
