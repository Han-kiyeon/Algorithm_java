
import java.util.*;
import java.io.*;

public class Main1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = 0;
		int n = Integer.parseInt(br.readLine());
		int h[] = new int[40001];
		Queue<int[]> q = new LinkedList<int[]>();
		int prev = 0;
		st = new StringTokenizer(br.readLine());
		st.nextToken(); // 0번째는 무조건 0,0
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (i % 2 == 0) {
				q.add(new int[] { x, x - prev });
				h[x] = y;
			}
			prev = x;
		}
		System.out.println(Arrays.toString(h));
		int k = Integer.parseInt(br.readLine());

		TreeMap<int[], Integer> map = new TreeMap<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map.put(new int[] { a, c }, b);
		}
		int prev_h = 0;
		int min = Integer.MAX_VALUE;
		for (int[] key : map.keySet()) {
			System.out.println(Arrays.toString(key));
			int next_h = map.get(key);
			min = Math.min(next_h, min);

			int H = Math.max(prev_h, next_h);
			while (q.size() > 0 && q.peek()[0] <= key[0]) {
				int[] p = q.poll();
				System.out.println("   "+ Arrays.toString(p));
				answer += p[1] * (h[p[0]] - H);
			}
			q.poll();
			prev_h = next_h;
		}
		while (!q.isEmpty()) {
			int[] p = q.poll();
			answer += p[1] * (h[p[0]] - min);
		}
		System.out.println(answer);
	}

}