import java.io.*;
import java.util.*;

public class Main_백준_2667_단지번호붙이기_서울8반_한기연 {
	static int[][] map, visit;
	static int N, count;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean range(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N)
			return true;
		return false;
	}

	static void solve(int i, int j, int cnt) {
		for (int k = 0; k < 4; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			if (range(ni, nj) && map[ni][nj] == 1) {
				map[i][j] = cnt;
				solve(ni, nj, cnt);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		count = 1;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					map[i][j] = ++count;
					solve(i, j, count);
				}
			}
		}
		for (int[] x : map)
			System.out.println(Arrays.toString(x));
		System.out.println(count - 1);
		sc.close();
	}
}
