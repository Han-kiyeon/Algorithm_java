package com.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행_한기연3 {
	private static char[][] map;
	private static int[] visited;
	private static int max;
	private static int R;
	private static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();

			}

			visited = new int['Z' + 1];

			visited[map[0][0]]++;
			max = 1;
			dfs(0, 0, 1);

			sb.append('#').append(tc).append(' ').append(max).append('\n');
		}
		System.out.print(sb);
	}

	public static void dfs(int r, int c, int step) {

		if (max == 26)
			return;
		if (max < step)
			max = step;

		if (0 <= r - 1 && visited[map[r - 1][c]] == 0) {
			visited[map[r - 1][c]]++;

			dfs(r - 1, c, step + 1);

			visited[map[r - 1][c]]--;
		}

		if (r + 1 < R && visited[map[r + 1][c]] == 0) { // 하
			visited[map[r + 1][c]]++;
			dfs(r + 1, c, step + 1);
			visited[map[r + 1][c]]--;
		}

		if (0 <= c - 1 && visited[map[r][c - 1]] == 0) { // 좌
			visited[map[r][c - 1]]++;
			dfs(r, c - 1, step + 1);
			visited[map[r][c - 1]]--;
		}

		if (c + 1 < C && visited[map[r][c + 1]] == 0) { // 우
			visited[map[r][c + 1]]++;
			dfs(r, c + 1, step + 1);
			visited[map[r][c + 1]]--;
		}
	}
}
