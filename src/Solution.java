import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N;
	static List<Integer>[] list;
	static long[][] memo;
	static long mod = 1000000007;

	public static void main(String[] args) throws Exception, Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			list = new ArrayList[N + 1];
			for (int n = 0; n < N + 1; n++) {
				list[n] = new ArrayList<>();
			}

			memo = new long[2][N + 1];
			for (int n = 1; n < N; n++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				list[s].add(e);
				list[e].add(s);
			}
			System.out.println("#" + t + " " + (simul(1, 0, -1) + simul(1, 1, -1)) % mod);
		}
	}

	static long simul(int node, int color, int parent) {
		if (memo[color][node] != 0) { //
			return memo[color][node];
		}
		long time = 1; // 이 노드에서의 경우의 수 초기화
		if (color == 0) { // 이 노드의 색깔이 흰색일 경우
			for (int i = 0; i < list[node].size(); i++) {
				if (list[node].get(i) != parent) {
					// 모든 자식 노드들의 흰색 경우와 검은색 경우를 더해 곱한다
					time *= (simul(list[node].get(i), 0, node) + simul(list[node].get(i), 1, node));
					time %= mod;
				}
			}
		} else { // 이 노드의 색깔이 검은색일 경우
			for (int i = 0; i < list[node].size(); i++) {
				if (list[node].get(i) != parent) {
					// 모든 자식 노드들의 흰색 경우를 곱한다
					time *= simul(list[node].get(i), 0, node);
					time %= mod;
				}
			}
		}
		memo[color][node] = time; // 이 노드 이 색깔의 경우의 수를 저장한다
		return time; // 이 노드 이 색깔의 경우의 수를 반환한다
	}
}