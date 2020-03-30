package BOJ_Sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Silver2_1931_회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		for (int i = 0; i < N; i++) {
			pq.add(new int[] { sc.nextInt(), sc.nextInt() });
		}

		int idx = 0;
		int ans = 0;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (idx <= now[0]) {
				// System.out.println(Arrays.toString(now));
				idx = now[1];
				ans++;
			}
		}
		System.out.println(ans);
	}
}