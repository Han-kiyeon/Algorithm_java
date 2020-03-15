package BOJ.BF;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold2_2048_Easy.java
 *
 * @Date : 2020. 3. 15.
 * @작성자 : 한기연
 * @메모리 : 44464 kb
 * @실행시간 : 736 ms
 *
 * @Blog : __
 **/

public class Gold2_12100_2048_Easy {
	static int N, ans;
	static int[][] map;
	static int[] data;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = 0;
		data = new int[5];

		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		solve(0, 0);
		System.out.println(ans);

	}

	private static void solve(int index, int depth) {
		if (depth == 5) {
			check();
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (data[depth] == 0) {
				data[depth] = i;
				solve(index, depth + 1);
				data[depth] = 0;
			}
		}
	}

	private static void check() {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}

		for (int time = 0; time < 5; time++) {
			switch (data[time]) {
			case 0: // 상
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (copy[r][c] != 0) {
							list[c].add(copy[r][c]);
							copy[r][c] = 0;
						}
					}
				}
				for (int i = 0; i < N; i++) {
					int r = 0;
					while (list[i].size() != 0) {
						if (list[i].size() != 1 && list[i].get(0).equals(list[i].get(1))) {
							copy[r++][i] = list[i].get(0) << 1;
							list[i].remove(0);
							list[i].remove(0);
						} else {
							copy[r++][i] = list[i].get(0);
							list[i].remove(0);
						}
					}
				}
				break;

			case 1: // 하
				for (int r = N - 1; r >= 0; r--) {
					for (int c = 0; c < N; c++) {
						if (copy[r][c] != 0) {
							list[c].add(copy[r][c]);
							copy[r][c] = 0;
						}
					}
				}

				for (int i = 0; i < N; i++) {
					int r = N - 1;
					while (list[i].size() != 0) {
						if (list[i].size() != 1 && list[i].get(0).equals(list[i].get(1))) {
							copy[r--][i] = list[i].get(0) << 1;
							list[i].remove(0);
							list[i].remove(0);
						} else {
							copy[r--][i] = list[i].get(0);
							list[i].remove(0);
						}
					}
				}
				break;
			case 2: // 좌
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (copy[r][c] != 0) {
							list[r].add(copy[r][c]);
							copy[r][c] = 0;
						}
					}
				}

				for (int i = 0; i < N; i++) {
					int c = 0;
					while (list[i].size() != 0) {
						if (list[i].size() != 1 && list[i].get(0).equals(list[i].get(1))) {
							copy[i][c++] = list[i].get(0) << 1;
							list[i].remove(0);
							list[i].remove(0);
						} else {
							copy[i][c++] = list[i].get(0);
							list[i].remove(0);
						}
					}
				}
				break;
			case 3: // 우
				for (int r = 0; r < N; r++) {
					for (int c = N - 1; c >= 0; c--) {
						if (copy[r][c] != 0) {
							list[r].add(copy[r][c]);
							copy[r][c] = 0;
						}
					}
				}

				for (int i = 0; i < N; i++) {
					int c = N - 1;
					while (list[i].size() != 0) {
						if (list[i].size() != 1 && list[i].get(0).equals(list[i].get(1))) {
							copy[i][c--] = list[i].get(0) << 1;
							list[i].remove(0);
							list[i].remove(0);
						} else {
							copy[i][c--] = list[i].get(0);
							list[i].remove(0);
						}
					}
				}
				break;
			}// end of switch
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max < copy[i][j])
					max = copy[i][j];
			}
		}

		if (ans < max)
			ans = max;

	}
}