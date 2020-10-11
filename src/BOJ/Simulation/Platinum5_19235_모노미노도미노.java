package BOJ.Simulation;
import java.util.Scanner;

public class Platinum5_19235_모노미노도미노 {
	static int BLUE = 0, GREEN = 1;
	static int N, score, count;
	static int board[][][] = new int[2][10][4];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		score = count = 0;
		for (int i = 0; i < N; ++i) {
			int t, r, c;
			t = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			put(t, r, BLUE, i + 1);
			put(t, c, GREEN, i + 1);
		}
		for (int color = 0; color < 2; ++color) {
			for (int r = 4; r < 10; ++r) {
				for (int c = 0; c < 4; ++c) {
					if (board[color][r][c] != 0) {
						++count;
					}
				}
			}
		}

		System.out.println(score);
		System.out.println(count);
	}

	private static void put(int type, int target, int color, int label) {
		if (type == 1) {
			board[color][0][target] = label;
			move_1x1(0, target, color);
		} else if ((type == 2 && color == BLUE) || (type == 3 && color == GREEN)) {
			board[color][0][target] = label;
			board[color][1][target] = label;
			move_2x1(1, target, color);
		} else if ((type == 3 && color == BLUE) || (type == 2 && color == GREEN)) {
			board[color][0][target] = label;
			board[color][0][target + 1] = label;
			move_1x2(0, target, color);
		}

		deleteFilled(color);
		deleteOverflow(color);
	}

	private static void deleteOverflow(int color) {
		int offset = 0;
		for (int r = 4; r <= 5; ++r) {
			boolean has_block = false;
			for (int c = 0; c < 4; ++c) {
				if (board[color][r][c] != 0) {
					has_block = true;
					break;
				}
			}
			if (has_block) {
				++offset;
			}
		}
		if (offset > 0) {
			for (int r = 9; r >= 6; --r) {
				for (int c = 0; c < 4; ++c) {
					board[color][r][c] = board[color][r - offset][c];
				}
			}
			for (int r = 4; r <= 5; ++r) {
				for (int c = 0; c < 4; ++c) {
					board[color][r][c] = 0;
				}
			}
		}
	}

	private static void deleteFilled(int color) {
		boolean is_remove = false;
		for (int r = 6; r < 10; ++r) {
			int count = 0;
			for (int c = 0; c < 4; ++c) {
				if (board[color][r][c] != 0) {
					++count;
				}
			}
			if (count == 4) {
				is_remove = true;
				++score;
				remove(r, color);
				move(r - 1, color);
			}
		}
		if (is_remove) {
			deleteFilled(color);
		}
	}

	private static void move(int start, int color) {
		int dr[] = { -1, 0 };
		int dc[] = { 0, +1 };
		for (int r = start; r >= 4; --r) {
			for (int c = 0; c < 4; ++c) {
				if (board[color][r][c] == 0) {
					continue;
				}
				int trpe = 1;
				for (int d = 0; d < 2; ++d) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 4 || nc >= 4) {
						continue;
					}
					if (board[color][r][c] == board[color][nr][nc]) {
						if (d == 0) {
							trpe = 2;
						} else {
							trpe = 3;
						}
					}
				}
				if (trpe == 1) {
					move_1x1(r, c, color);
				} else if (trpe == 2) {
					move_2x1(r, c, color);
				} else if (trpe == 3) {
					move_1x2(r, c, color);
				}
			}
		}
	}

	private static void remove(int r, int color) {
		for (int c = 0; c < 4; ++c) {
			board[color][r][c] = 0;
		}
	}

	private static void move_1x2(int r, int c, int color) {
		int label = board[color][r][c];
		board[color][r][c] = 0;
		board[color][r][c + 1] = 0;

		while (r < 10) {
			if (board[color][r][c] != 0 || board[color][r][c + 1] != 0) {
				break;
			}
			++r;
		}
		--r;

		board[color][r][c] = label;
		board[color][r][c + 1] = label;
	}

	private static void move_2x1(int r, int c, int color) {
		int label = board[color][r][c];
		board[color][r][c] = 0;
		board[color][r - 1][c] = 0;

		while (r < 10) {
			if (board[color][r][c] != 0) {
				break;
			}
			++r;
		}
		--r;

		board[color][r][c] = label;
		board[color][r - 1][c] = label;
	}

	private static void move_1x1(int r, int c, int color) {
		int label = board[color][r][c];
		board[color][r][c] = 0;

		while (r < 10) {
			if (board[color][r][c] != 0) {
				break;
			}
			++r;
		}
		--r;

		board[color][r][c] = label;
	}

}