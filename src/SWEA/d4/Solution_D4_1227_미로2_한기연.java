package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1227_미로2_한기연 {

	static int map[][];
	static boolean visit[][];
	static int N = 100; // mapSize
	static int sy, sx, answer;
	// ------------------상, 하, 좌, 우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static void solve(int y, int x) {
		visit[y][x] = true;
		if (map[y][x] == 3) {
			answer = 1;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (check(nx) && check(ny))
				if (!visit[ny][nx] && map[ny][nx] != 1)
					solve(ny, nx);
		}
	}

	static boolean check(int x) {
		if (0 <= x && x < N)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1227_D4_미로2.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10; // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();// 테스트 케이스 번호
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next(); // 한 줄 읽어옴.
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0'; // parse
					if (map[i][j] == 2) { // 출발점
						sy = i;
						sx = j;
					}
				}
			}
			answer = 0;
			solve(sy, sx);
			System.out.println("#" + tc + " " + answer);

		}
		sc.close(); // Scanner close
	}
}
