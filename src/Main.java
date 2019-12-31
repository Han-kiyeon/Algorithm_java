import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int N, M, cnt, ans;
	static int[][] map;
	static LinkedList<int[]> list;
	static int[] memo;
	static int[] data;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		list = new LinkedList<>();
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0)
					cnt++;
				else if (map[i][j] != 6)
					list.add(new int[] { map[i][j], i, j });
			}
		}
		System.out.println(cnt);
		for (int[] is : list) {
			System.out.println(Arrays.toString(is));
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[0] == 5) {
				System.out.println(Arrays.toString(list.get(i)));
				int[] now = list.get(i);
				list.remove(i);
				i--;
				cnt -= up(now[1], now[2]);
				cnt -= down(now[1], now[2]);
				cnt -= left(now[1], now[2]);
				cnt -= right(now[1], now[2]);
			}
		}
		System.out.println(cnt);
		for (int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
		memo = new int[list.size()];
		data = new int[list.size()];
		ans = cnt;
		solve(0, 0);
		System.out.println(ans);
	}

	private static void solve(int depth, int dir) {
		if (depth == list.size()) {
			System.out.println(Arrays.toString(data));
			return;
		}
		for (int i = depth; i < list.size(); i++) {
			int k = list.get(i)[0] == 2 ? 2 : 4;
			for (int j = dir; j < k; j++) {
				data[depth] = j;
				solve(depth + 1, j);
			}
		}
	}

	private static int right(int i, int j) {
		int ret = 0;
		while (true) {
			j++;
			if (!isRange(i, j) || map[i][j] == 6)
				break;
			if (map[i][j] == 0) {
				ret++;
				map[i][j] = 8;
			}
		}
		return ret;
	}

	private static int left(int i, int j) {
		int ret = 0;
		while (true) {
			j--;
			if (!isRange(i, j) || map[i][j] == 6)
				break;
			if (map[i][j] == 0) {
				ret++;
				map[i][j] = 8;
			}
		}
		return ret;
	}

	private static int down(int i, int j) {
		int ret = 0;
		while (true) {
			i++;
			if (!isRange(i, j) || map[i][j] == 6)
				break;
			if (map[i][j] == 0) {
				ret++;
				map[i][j] = 8;
			}
		}
		return ret;
	}

	private static int up(int i, int j) {
		int ret = 0;
		while (true) {
			i--;
			if (!isRange(i, j) || map[i][j] == 6)
				break;
			if (map[i][j] == 0) {
				ret++;
				map[i][j] = 8;
			}
		}
		return ret;
	}

	private static boolean isRange(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < M)
			return true;
		return false;
	}
}