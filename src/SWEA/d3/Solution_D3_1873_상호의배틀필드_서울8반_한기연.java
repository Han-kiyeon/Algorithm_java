package com.d3;

import java.io.*;
import java.util.*;

public class Solution_D3_1873_상호의배틀필드_서울8반_한기연 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D3_1873_상호의배틀필드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			for (int i = 0; i < map.length; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int tank_x = 0;
			int tank_y = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<'
							|| map[i][j] == '>') {
						tank_x = i;
						tank_y = j;
						break;
					}
				}
			}

			int orderLength = Integer.parseInt(br.readLine());
			String order = br.readLine();
			for (int i = 0; i < orderLength; i++) {
				switch (order.charAt(i)) {
				case 'S':
					switch (map[tank_x][tank_y]) {
					case '^':
						for (int j = 1; tank_x - j >= 0; j++) {
							if (map[tank_x - j][tank_y] == '*') {
								map[tank_x - j][tank_y] = '.';
								break;
							}
							if (map[tank_x - j][tank_y] == '#') {
								break;
							}
						}
						break;
					case 'v':
						for (int j = 1; tank_x + j < N; j++) {
							if (map[tank_x + j][tank_y] == '*') {
								map[tank_x + j][tank_y] = '.';
								break;
							}
							if (map[tank_x + j][tank_y] == '#') {
								break;
							}
						}
						break;
					case '<':
						for (int j = 1; tank_y - j >= 0; j++) {
							if (map[tank_x][tank_y - j] == '*') {
								map[tank_x][tank_y - j] = '.';
								break;
							}
							if (map[tank_x][tank_y - j] == '#') {
								break;
							}
						}
						break;
					case '>':
						for (int j = 1; tank_y + j < M; j++) {
							if (map[tank_x][tank_y + j] == '*') {
								map[tank_x][tank_y + j] = '.';
								break;
							}
							if (map[tank_x][tank_y + j] == '#') {
								break;
							}
						}
						break;
					}
					break;
				case 'U':
					if (tank_x - 1 >= 0) {
						if (map[tank_x - 1][tank_y] == '.') {
							map[tank_x--][tank_y] = '.';
							map[tank_x][tank_y] = '^';
						} else {
							map[tank_x][tank_y] = '^';
						}
					} else {
						map[tank_x][tank_y] = '^';
					}
					break;
				case 'D':
					if (tank_x + 1 < N) {
						if (map[tank_x + 1][tank_y] == '.') {
							map[tank_x++][tank_y] = '.';
							map[tank_x][tank_y] = 'v';
						} else {
							map[tank_x][tank_y] = 'v';
						}
					} else {
						map[tank_x][tank_y] = 'v';
					}
					break;
				case 'L':
					if (tank_y - 1 >= 0) {
						if (map[tank_x][tank_y - 1] == '.') {
							map[tank_x][tank_y--] = '.';
							map[tank_x][tank_y] = '<';
						} else {
							map[tank_x][tank_y] = '<';
						}
					} else {
						map[tank_x][tank_y] = '<';
					}
					break;
				case 'R':
					if (tank_y + 1 < M) {
						if (map[tank_x][tank_y + 1] == '.') {
							map[tank_x][tank_y++] = '.';
							map[tank_x][tank_y] = '>';
						} else {
							map[tank_x][tank_y] = '>';
						}
					} else {
						map[tank_x][tank_y] = '>';
					}
					break;
				}
			}
			System.out.printf("#%d ", t);
			for (char[] cs : map) {
				System.out.println(cs);
			}
		} // end of test case
		br.close();
	} // end of main
}
