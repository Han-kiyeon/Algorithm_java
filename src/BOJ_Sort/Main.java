package BOJ_Sort;
import java.util.Scanner;

public class Main {
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