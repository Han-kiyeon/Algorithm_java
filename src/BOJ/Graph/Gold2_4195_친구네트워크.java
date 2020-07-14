package BOJ.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Gold2_4195_친구네트워크 {
	static int[] parent;
	static int[] size;
	static Map<String, Integer> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 개수
		for (int tc = 0; tc < T; tc++) {
			int F = sc.nextInt(); // 친구 관계의 수 F <= 100,000

			parent = new int[2 * F]; // 관계 수 * 2 만큼 사람이 있을수 잇지..
			size = new int[2 * F];

			for (int i = 0; i < parent.length; i++) {
				parent[i] = i; // makeSet
				size[i] = 1; // 집합의 크기
			}

			map = new HashMap<>();
			for (int k = 0; k < F; k++) {
				String p1 = sc.next(); // 친구 1
				String p2 = sc.next(); // 친구 2
				if (!map.containsKey(p1))
					map.put(p1, map.size());
				if (!map.containsKey(p2))
					map.put(p2, map.size());

				System.out.println(union(map.get(p1), map.get(p2)));
			}
		} // end of TC
	}// end of main

	private static int union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px != py) {
			if (px < py) {
				parent[py] = px;
				size[px] = size[py] = size[px] + size[py];
				return size[px];
			} else {
				parent[px] = py;
				size[px] = size[py] = size[px] + size[py];
				return size[py];
			}
		}
		return size[px];
	}

	private static int find(int x) {
		if (x == parent[x])
			return x;
		return x = find(parent[x]);
	}
}
