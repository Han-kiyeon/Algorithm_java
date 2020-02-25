package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_7699_수지의수지맞는여행_한기연 {
	private static int R, C, result;
	private static char[][] island;
	private static LinkedList<Character> list;

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	private static boolean range(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C)
			return true;
		else
			return false;
	}

	private static boolean visit(int x, int y) {
		for (int i = 0; i < list.size(); i++)
			if (island[x][y] == list.get(i))
				return true;// 갔어~
		return false;// 아직 안갔어
	}

	private static void DFS(int x, int y) {
		result = (result > list.size()) ? result : list.size();
		if(result==26)
			return;
		for (int k = 0; k < 4; k++) {
			int ni = x + dx[k];
			int nj = y + dy[k];
			if (range(ni, nj) && !visit(ni, nj)) {
				list.add(island[ni][nj]);
				DFS(ni, nj);
				list.removeLast();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D4_7699_수지의수지맞는여행.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			island = new char[R][C];
			list = new LinkedList<>();

			for (int i = 0; i < R; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < C; j++)
					island[i][j] = tmp.charAt(j);
			}
			//for (char[] x : island)
			//	System.out.println(Arrays.toString(x));
			///////////// 입력끝~!!

			list.add(island[0][0]);
			result = Integer.MIN_VALUE;
			DFS(0, 0);
			
			System.out.println("#" + tc + " " + result);
		}
		br.close();
	}
}
