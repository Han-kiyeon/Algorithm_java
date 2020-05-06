package BOJ.Simulation;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Gold5_11559_PuyoPuyo.java
 *
 * @Date : 2020. 5. 6.
 * @작성자 : 한기연
 * @메모리 : 14508 kb
 * @실행시간 : 104 ms
 *
 * @Blog : __
 **/
public class Gold5_11559_PuyoPuyo {
	static int H, W, ans;

	static char[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static boolean[][] visit;
	static Queue<int[]> q;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = 12;
		W = 6;
		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			String str = sc.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		q = new LinkedList<>();
		flag = true;
		while (flag) {
			flag = false;
			visit = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '.')
						continue;
					if (BFS(i, j))
						flag = true;
				}
			}
			if (flag) {
				fall();
			}
		}
		System.out.println(ans);
	}

	private static void fall() {
		for (int j = 0; j < W; j++) {
			int index = -1;
			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] == '.' && index == -1)
					index = i;
				else if (map[i][j] != '.' && index != -1) {
					int gap = index - i;
					for (int k = i; k >= 0; k--) {
						map[k + gap][j] = map[k][j];
						map[k][j] = '.';
					}
					i = index;
					index = -1;
				}
			}
		}

	}

	private static boolean BFS(int r, int c) {
		ArrayList<int[]> list = new ArrayList<>();
		visit[r][c] = true;
		q.add(new int[] { r, c });
		list.add(new int[] { r, c });
		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (isRange(nr, nc) && !visit[nr][nc] && map[nr][nc] == map[r][c]) {
					visit[nr][nc] = true;
					q.add(new int[] { nr, nc });
					list.add(new int[] { nr, nc });
				}
			}
		}
		if (list.size() >= 4) {
			for (int[] is : list) {
				map[is[0]][is[1]] = '.';
			}
			if (!flag)
				ans++;
			return true;
		} else
			return false;
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < H && 0 <= nc && nc < W)
			return true;
		return false;
	}
}