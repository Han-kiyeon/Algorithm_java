package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold3_1525_퍼즐.java
 *
 * @Date : 2020. 3. 22.
 * @작성자 : 한기연
 * @메모리 : 63944 kb
 * @실행시간 : 688 ms
 *
 * @Blog : __
 **/
public class Gold3_1525_퍼즐 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int map = 0;
		int[] start = new int[2];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int tmp = sc.nextInt();
				map *= 10;
				map += tmp;
				if (tmp == 0) {
					map += 9;
					start[0] = i;
					start[1] = j;
				}
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { map, start[0], start[1], 0 });
		Set<Integer> set = new TreeSet<>();
		set.add(map);
		while (!q.isEmpty()) {
			if (q.peek()[0] == 123456789) {
				System.out.println(q.peek()[3]);
				System.exit(0);
			}

			char[] now = ("" + q.peek()[0]).toCharArray();
			int r = q.peek()[1];
			int c = q.peek()[2];
			int cnt = q.peek()[3];
			q.poll();

			for (int k = 0; k < dr.length; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (isRange(nr, nc)) {
					int next = getNext(now, r * 3 + c, nr * 3 + nc);
					if (!set.contains(next)) {
						set.add(next);
						q.offer(new int[] { next, nr, nc, cnt + 1 });
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static int getNext(char[] now, int i, int j) {
		char tmp = now[i];
		now[i] = now[j];
		now[j] = tmp;
		int ret = 0;
		for (char c : now) {
			ret *= 10;
			ret += c - '0';
		}
		tmp = now[i];
		now[i] = now[j];
		now[j] = tmp;
		return ret;
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < 3 && 0 <= nc && nc < 3)
			return true;
		return false;
	}

}