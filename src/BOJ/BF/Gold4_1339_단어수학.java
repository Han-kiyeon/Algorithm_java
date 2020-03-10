package BOJ.BF;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold4_1339_단어수학.java
 *
 * @Date : 2020. 3. 10.
 * @작성자 : 한기연
 * @메모리 : 19080 kb
 * @실행시간 : 1408 ms
 *
 * @Blog : __
 **/

public class Gold4_1339_단어수학 {
	static int N, max;
	static String[] words;

	static Map<Character, Integer> alphabet;
	static boolean[] visit;
	static int[] data;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		words = new String[N];

		alphabet = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			words[i] = sc.next();
			for (int j = 0; j < words[i].length(); j++) {
				if (!alphabet.containsKey(words[i].charAt(j))) {
					alphabet.put(words[i].charAt(j), count++);
				}
			}
		}
		data = new int[alphabet.size()];
		visit = new boolean[10];
		max = Integer.MIN_VALUE;
		solve(0, 0);
		System.out.println(max);
	}

	private static void solve(int index, int depth) {
		if (depth == data.length) {
			check();
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!visit[i]) {
				visit[i] = true;
				data[depth] = i;
				solve(i, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static void check() {
		int ret = 0;
		for (int i = 0; i < words.length; i++) {
			int tmp = 0;
			for (int j = 0; j < words[i].length(); j++) {
				tmp += data[alphabet.get(words[i].charAt(j))];
				tmp *= 10;
			}
			ret += tmp / 10;
		}
		if (max < ret)
			max = ret;
	}
}