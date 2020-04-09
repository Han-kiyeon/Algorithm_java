package BOJ.Simulation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Gold3_8982_수족관1.java
 *
 * @Date : 2020. 4. 10.
 * @작성자 : 한기연
 * @메모리 : 36632 kb
 * @실행시간 : 420 ms
 *
 * @Blog : __
 **/
public class Gold3_8982_수족관1 {
	static int N, K;
	static int[][] map;
	static int W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		sc.nextInt();
		sc.nextInt();
		for (int i = 0; i < N - 2; i += 2) {
			Point p1 = new Point(sc.nextInt(), sc.nextInt());
			Point p2 = new Point(sc.nextInt(), sc.nextInt());
			for (int j = p1.x; j < p2.x; j++) {
				list.add(p1.y);
			}
		}
		sc.nextInt();
		sc.nextInt();
		W = list.size();
		K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			Point p1 = new Point(sc.nextInt(), sc.nextInt());
			Point p2 = new Point(sc.nextInt(), sc.nextInt());
			int c = (p1.x + p2.x) / 2;
			int left = c, right = c;

			int tmp = list.get(c);
			while (left > 0) {
				if (tmp == 0)
					break;
				left--;
				if (list.get(left) < tmp) {
					tmp = list.get(left);
				}
				list.set(left, list.get(left) - tmp);
			}

			tmp = list.get(c);
			while (right < W - 1) {
				if (tmp == 0)
					break;
				right++;
				if (list.get(right) <= tmp) {
					tmp = list.get(right);
				}
				list.set(right, list.get(right) - tmp);
			}

			list.set(c, 0);
		}

		int ans = 0;
		for (Integer i : list) {
			if (i > 0)
				ans += i;
		}

		System.out.println(ans);
	}
}