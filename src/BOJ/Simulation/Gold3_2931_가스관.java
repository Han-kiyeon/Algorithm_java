package BOJ.Simulation;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gold3_2931_가스관 {
	static int R, C;
	static char[][] map;
	static int[] M, Z;
	static char[] pipeArr = { '|', '-', '+', '1', '2', '3', '4' };
	static Map<Character, Integer> pipe;
	static int[][][] dir = {
			{ { 1, 0 }, { -1, 0 } }, // '|'
			{ { 0, -1 }, { 0, 1 } }, // '-'
			{ { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }, // '+'
			{ { 0, 1 }, { 1, 0 } }, // '1'
			{ { -1, 0 }, { 0, 1 } }, // '2'
			{ { 0, -1 }, { 1, 0 } }, // '3'
			{ { 0, -1 }, { 1, 0 } },// '4'
	};
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'M') {
					M = new int[] { i, j };
				} else if (map[i][j] == 'Z') {
					Z = new int[] { i, j };
				}
			}
		}

		pipe = new HashMap<>();
		pipe.put('|', 0);
		pipe.put('-', 1);
		pipe.put('+', 2);
		pipe.put('1', 3);
		pipe.put('2', 4);
		pipe.put('3', 5);
		pipe.put('4', 6);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					for (int k = 0; k < pipeArr.length; k++) {
						if (check(i, j, pipe.get(pipeArr[k]))) {
							map[i][j] = pipeArr[k];
							if (go()) {
								System.out.println((i + 1) + " " + (j + 1) + " " + pipeArr[k]);
								return;
							}
							map[i][j] = '.';
						}
					}
				}
			}
		}

	}

	private static boolean go() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.')
					continue;
				else if (map[i][j] == 'M' || map[i][j] == 'Z') {
					int cnt = 0;
					if (isRange(i - 1, j) && (map[i - 1][j] == '|' || map[i - 1][j] == '1' || map[i - 1][j] == '4' || map[i - 1][j] == '+'))
						cnt++;
					if (isRange(i + 1, j) && (map[i + 1][j] == '|' || map[i + 1][j] == '2' || map[i + 1][j] == '3' || map[i + 1][j] == '+'))
						cnt++;
					if (isRange(i, j - 1) && (map[i][j - 1] == '-' || map[i][j - 1] == '1' || map[i][j - 1] == '2' || map[i][j - 1] == '+'))
						cnt++;
					if (isRange(i, j + 1) && (map[i][j + 1] == '-' || map[i][j + 1] == '3' || map[i][j + 1] == '4' || map[i][j + 1] == '+'))
						cnt++;
					if (cnt != 1)
						return false;

				} else if (!check(i, j, pipe.get(map[i][j])))
					return false;
			}
		}
		return true;

	}

	private static boolean check(int i, int j, int num) {
		switch (num) {
			case 0:
				if (up(i, j) || down(i, j))
					break;
				return true;
			case 1:
				if (left(i, j) || right(i, j))
					break;
				return true;
			case 2:
				if (up(i, j) || down(i, j) || left(i, j) || right(i, j))
					break;
				return true;
			case 3:
				if (down(i, j) || right(i, j))
					break;
				return true;
			case 4:
				if (up(i, j) || right(i, j))
					break;
				return true;
			case 5:
				if (up(i, j) || left(i, j))
					break;
				return true;
			case 6:
				if (down(i, j) || left(i, j))
					break;
				return true;
		}
		return false;
	}

	private static boolean up(int i, int j) {
		return (!isRange(i - 1, j) || map[i - 1][j] == '.' || map[i - 1][j] == '-' || map[i - 1][j] == '2'	|| map[i - 1][j] == '3');
	}

	private static boolean down(int i, int j) {
		return (!isRange(i + 1, j) || map[i + 1][j] == '.' || map[i + 1][j] == '-' || map[i + 1][j] == '1'	|| map[i + 1][j] == '4');
	}

	private static boolean left(int i, int j) {
		return (!isRange(i, j - 1) || map[i][j - 1] == '.' || map[i][j - 1] == '|' || map[i][j - 1] == '3'	|| map[i][j - 1] == '4');
	}

	private static boolean right(int i, int j) {
		return (!isRange(i, j + 1) || map[i][j + 1] == '.' || map[i][j + 1] == '|' || map[i][j + 1] == '1'	|| map[i][j + 1] == '2');
	}

	private static boolean isRange(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}