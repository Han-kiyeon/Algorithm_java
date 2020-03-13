package BOJ.DFS_BFS;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold4_2580_스도쿠.java
 *
 * @Date : 2020. 3. 13.
 * @작성자 : 한기연
 * @메모리 : 21504 kb
 * @실행시간 : 524 ms
 *
 * @Blog : __
 **/

public class Gold4_2580_스도쿠 {
	static int[][] map;
	static LinkedList<int[]> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new int[9][9];
		list = new LinkedList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}
		solve(0);
	}

	private static void solve(int depth) {
		if (depth == list.size()) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			sb.append("\n");

			System.out.println(sb);
			System.exit(0);
		}

		int r = list.get(depth)[0];
		int c = list.get(depth)[1];

		for (int i = 1; i <= 9; i++) {
			if (check(r, c, i)) {
				map[r][c] = i;
				solve(depth + 1);
				map[r][c] = 0;
			}
		}

	}

	private static boolean check(int r, int c, int num) {
		if (map[r][c] != 0)
			return false;

		for (int i = 0; i < 9; i++) {
			if (map[i][c] == num || map[r][i] == num) // 가로 세로
				return false;
		}
		int sr = (r / 3) * 3, sc = (c / 3) * 3;
		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (map[i][j] == num)  // 3x3
					return false;
			}
		}

		return true;
	}

}