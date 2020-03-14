package BOJ.BF;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold4_1062_가르침.java
 *
 * @Date : 2020. 3. 14.
 * @작성자 : 한기연
 * @메모리 : 15284 kb
 * @실행시간 : 2140 ms
 *
 * @Blog : __
 **/

public class Gold4_1062_가르침 {
	static int N, K, ans;
	static boolean[][] word;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N은 50보다 작거나 같은 자연수
		K = sc.nextInt(); // K는 26보다 작거나 같은 자연수 또는 0

		// N개의 줄에 남극 언어의 단어
		word = new boolean[N][26];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < tmp.length(); j++) {
				word[i][tmp.charAt(j) - 'a'] = true;
			}
		}
		visit = new boolean[26];
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
			if (!visit[i]) {
				visit[i] = true;
				solve(i, depth + 1);
				visit[i] = false;
			}
		}

	}

	private static void check() {
		int ret = 0;

		boolean flag = true;
		for (int k = 0; k < N; k++) {
			flag = true;
			for (int i = 0; i < 26; i++) {
				if (word[k][i] && !visit[i]) {
					flag = false;
					break;
				}
			}
			if (flag)
				ret++;
		}

		ans = Math.max(ret, ans);
	}
}