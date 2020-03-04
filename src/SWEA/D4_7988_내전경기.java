package SWEA;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D4_7988_내전경기.java
 *
 * @Date : 2020. 3. 4.
 * @작성자 : 한기연
 * @메모리 : 68,456 kb
 * @실행시간 : 215 ms
 *
 * @Blog : __
 **/
public class D4_7988_내전경기 {
	static int K, count;
	static int[][] map;
	static HashMap<String, Integer> player;

	static int[] team;
	static boolean ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			K = sc.nextInt();
			player = new HashMap<>();
			map = new int[K << 1][K << 1];
			count = 0;
			for (int k = 0; k < K; k++) {
				String name1 = sc.next();
				String name2 = sc.next();
				if (!player.containsKey(name1)) {
					player.put(name1, count++);
				}
				if (!player.containsKey(name2)) {
					player.put(name2, count++);
				}
				int p1 = player.get(name1);
				int p2 = player.get(name2);
				map[p1][p2] = 1;
				map[p2][p1] = 1;
			}
			team = new int[count];
			ans = true;
			for (int i = 0; i < count; i++) {
				if (team[i] == 0) { // 팀 미정
					team[i] = 1; // 일단 1번팀으로.
					bfs(i);
				}
				if (!ans)
					break;
			}

			System.out.println("#" + tc + " " + (ans ? "Yes" : "No"));
		} // end of TC
	}// end of main

	private static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(idx);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < count; i++) {
				if (map[cur][i] == 1) { // 시너지
					if (team[i] != 0 && team[i] == team[cur]) {
						ans = false;
						return;
					}

					if (team[i] == 0) {
						team[i] = team[cur] == 1 ? 2 : 1;
						queue.add(i);
					}

				}
			}
		}
	}
}