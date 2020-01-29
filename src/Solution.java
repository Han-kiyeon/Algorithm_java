class Solution {
	static int len, ans;
	static boolean[] visit;
	static String[] input;

	public static void main(String[] args) {
		String[] a = { "eva", "jqw", "tyn", "jan" };
		System.out.println(solution(a));
	}

	public static int solution(String[] A) {
		input = A.clone();
		len = A.length;

		visit = new boolean[len];

		ans = 0;
		for (int i = 1; i <= len; i++) {
			solve(i, 0, 0);
		}
		return ans;
	}

	private static void solve(int n, int idx, int depth) {
		if (depth == n) {
			check();
			return;
		}
		for (int i = idx; i < len; i++) {
			if (!visit[i]) {
				visit[i] = true;
				solve(n, i, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static void check() {
		String str = "";
		int[] alpabet = new int[26];
		for (int i = 0; i < len; i++) {
			if (visit[i])
				str += input[i];
		}

		for (int i = 0; i < str.length(); i++) {
			alpabet[str.charAt(i) - 'a']++;
		}

		for (int i = 0; i < alpabet.length; i++) {
			if (alpabet[i] > 1)
				return;
		}
		if (ans < str.length())
			ans = str.length();
	}
}
