package com.d3;

import java.util.*;
import java.io.*;

public class Solution_D3_4615_재미있는오셀로게임_한기연 {
	static int N;
	static int[][] map;

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/D3_4615_재미있는오셀로게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			map[N / 2 - 1][N / 2 - 1] = 2;
			map[N / 2 - 1][N / 2] = 1;
			map[N / 2][N / 2 - 1] = 1;
			map[N / 2][N / 2] = 2;
			int M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int player = Integer.parseInt(st.nextToken());
				map[x][y] = player;
				solve(x, y, player);
			}
			int player1 = 0, player2 = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (map[i][j] == 1)
						player1++;
					else if (map[i][j] == 2)
						player2++;
			System.out.println(player1 + " " + player2);
		} // end of testCase

	}// end of main

	static void solve(int x, int y, int player) {
		for (int i = 0; i < 8; i++) {
			int[] tmp = check(x, y, dx[i], dy[i], player);
			if (tmp[0] == -1)
				continue;
			int nx = x;
			int ny = y;
			while (nx != tmp[0] || ny != tmp[1]) {
				nx += dx[i];
				ny += dy[i];
				map[nx][ny] = player;
			}
		}
	}

	static int[] check(int x, int y, int dirx, int diry, int player) {
		int nx = x + dirx;
		int ny = y + diry;
		while (true) {
			if (!range(nx, ny))
				break;
			else if (map[nx][ny] == 0)
				break;
			else if (map[nx][ny] != player) {
				nx += dirx;
				ny += diry;
			} else
				break;
		}
		if (range(nx, ny) && map[nx][ny] == player) {
			return new int[] { nx, ny };
		} else
			return new int[] { -1, -1 };
	}

	static boolean range(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N)
			return true;
		return false;
	}
}
