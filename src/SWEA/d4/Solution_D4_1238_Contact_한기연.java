package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1238_Contact_한기연 {
	public static Map<Integer, ArrayList<Integer>> map;
	public static int[] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1238_D4_Contact.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			map = new HashMap<>();
			visit = new int[101];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (!map.containsKey(from))
					map.put(from, new ArrayList<>());
				map.get(from).add(to);
			}

			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(start);
			visit[start] = 1;

			while (!q.isEmpty()) {
				int cur = q.poll();
				if (map.containsKey(cur))
					for (int i : map.get(cur))
						if (visit[i] == 0) {
							q.offer(i);
							visit[i] = visit[cur] + 1;
						}
			}

			int cnt = -1;
			for (int x : visit)
				cnt = (x > cnt) ? x : cnt;

			int result = -1;
			for (int i = 0; i < visit.length; i++)
				if (visit[i] == cnt)
					result = (result > i) ? result : i;
			

			//System.out.println(map);

			System.out.println("#" + tc + " " + result);
		}
		br.close();
	}

}
