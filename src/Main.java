import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		boolean[] visit = new boolean[100001];
		int[] path = new int[1000001];

		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] x, int[] y) -> x[1] >= y[1] ? 1 : -1);
		pq.offer(new int[] { N, 0 });
		visit[N] = true;
		path[N] = N; // 루트 노드 표시

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if (cur[0] == K) {
				System.out.println(cur[1]);
				// 경로 출력
				int v = K;
//				String result = v + "";
//				while (v != path[v]) { // 루트일때까지 반복
//					result = path[v] + " " + result;
//					v = path[v];
//				}
//				System.out.println(result);
				StringBuilder sb = new StringBuilder(v + "");
				while(v != path[v]) {
					sb.insert(0," ").insert(0, path[v]);
					v = path[v];
				}
				System.out.println(sb);
				break;
			}
			
			// +1
			int x = cur[0] + 1;
			if (isRange(x) && !visit[x]) {
				path[x] = cur[0];
				visit[x] = true;
				pq.offer(new int[] { x, cur[1] + 1 });
			}
			// -1
			x = cur[0] - 1;
			if (isRange(x) && !visit[x]) {
				path[x] = cur[0];
				visit[x] = true;
				pq.offer(new int[] { x, cur[1] + 1 });
			}
			// 2xcur[0]
			x = cur[0] << 1;
			if (isRange(x) && !visit[x]) {
				path[x] = cur[0];
				visit[x] = true;
				pq.offer(new int[] { x, cur[1] + 1 });
			}
		}

	}

	private static boolean isRange(int i) {
		if (0 <= i && i <= 100000)
			return true;
		return false;
	}
}