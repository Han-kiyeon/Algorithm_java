import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean visit[][];
	static int N, K, len;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		len = ("" + N).length();

		visit = new boolean[1000001][K + 1];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { N, 0 });
		visit[N][0] = true;

		int result = -1;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[1] == K) {
				if (result < now[0]) {
					result = now[0];
				}
				continue;
			}
			for (int i = 0; i < len - 1; i++) {
				for (int j = i + 1; j < len; j++) {
					int next = solve(now[0], i, j);
					if (next != -1 && !visit[next][now[1] + 1]) {
						visit[next][now[1] + 1] = true;
						q.add(new int[] { next, now[1] + 1 });
					}
				}
			}
		}

		System.out.println(result);

	}

	private static int solve(int x, int i, int j) {
		char[] input = ("" + x).toCharArray();

		if (i == 0 && input[j] == '0')
			return -1;

		char tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
		
		int ret = 0;
		for (int k = 0; k < input.length; k++) {
			ret *= 10;
			ret += input[k] - '0';
		}
		return ret;
	}
}
