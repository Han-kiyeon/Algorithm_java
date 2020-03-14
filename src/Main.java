import java.util.Scanner;

public class Main {
	static int N, K, ans;

	static int visit;
	static int[] word;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N은 50보다 작거나 같은 자연수
		K = sc.nextInt(); // K는 26보다 작거나 같은 자연수 또는 0

		// N개의 줄에 남극 언어의 단어
		word = new int[N];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < tmp.length(); j++) {
				word[i] |= (1 << (tmp.charAt(j) - 'a'));
			}
		}

		visit = 0;
		ans = 0;
		solve(0, 0);
		System.out.println(ans);

	}

	private static void solve(int index, int depth) {
		if (depth == K) {
			check();
			return;
		}
		for (int i = index; i < 26; i++) {
			if ((visit & (1 << (i))) == 0) {
				visit |= (1 << (i));
				solve(i, depth + 1);
				visit &= (0 << (i));
			}
		}

	}

	private static void check() {
		System.out.println(Integer.toString(visit, 2));
		int ret = 0;

		for (int k = 0; k < N; k++) {
			if (visit == word[k])
				ret++;
		}

		ans = Math.max(ret, ans);
	}
}