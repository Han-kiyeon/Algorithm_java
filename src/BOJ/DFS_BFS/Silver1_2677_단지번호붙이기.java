package BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Silver1_2677_단지번호붙이기.java
 *
 * @Date : 2019. 9. 2.
 * @작성자 : 한기연
 * @메모리 : 12960 kb
 * @실행시간 : 84 ms
 *
 * @Blog : __
 **/

public class Silver1_2677_단지번호붙이기 {
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

		Collections.sort(list);

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		br.close();
	}

}