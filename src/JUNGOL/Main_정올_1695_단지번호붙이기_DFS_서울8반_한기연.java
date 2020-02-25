package JUNGOL;

import java.io.*;
import java.util.*;

public class Main_정올_1695_단지번호붙이기_DFS_서울8반_한기연 {
	static int[][] map;
	static int N, cnt;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static boolean range(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N)
			return true;
		return false;
	}

	static int DFS(int x, int y) {
		map[x][y] = ++cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (range(nx, ny)) {
				if (map[nx][ny] == 1) {
					DFS(nx, ny);
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if (map[i][j] == 1) {
					cnt = 1;
					DFS(i, j);
					list.add(cnt - 1);
				}
		}
		for (int[] x : map)
			System.out.println(Arrays.toString(x));

		Collections.sort(list);

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		br.close();
	}

}