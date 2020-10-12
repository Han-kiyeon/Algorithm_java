package BOJ.Simulation;
import java.util.Scanner;

public class Gold3_19236_청소년상어 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] map = new int[4][4];
		int[][] fish = new int[16][3]; // 행|열|방향
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int num = sc.nextInt() - 1;
				int dir = sc.nextInt() - 1;
				fish[num][0] = i;
				fish[num][1] = j;
				fish[num][2] = dir;

				map[i][j] = num;
			}
		}

		int[] shark = new int[3]; // 행|열|방향
		solve(map, fish, shark, 0);

		System.out.println(ans);
	}

	private static void solve(int[][] original_map, int[][] original_fish, int[] original_shark, int score) {
		// copy
		int[][] map = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = original_map[i][j];
			}
		}

		int[][] fish = new int[16][3];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 3; j++) {
				fish[i][j] = original_fish[i][j];
			}
		}

		int[] shark = new int[3];
		for (int i = 0; i < 3; i++) {
			shark[i] = original_shark[i];
		}

		// eat
		int target = map[shark[0]][shark[1]];
		map[shark[0]][shark[1]] = -1; // 맵에서 물고기 죽음 처리
		fish[target][0] = -1; // 물고기 정보에서 죽음 처리
		shark[2] = fish[target][2]; // 상어의 이동방향 갱신

		score += (target + 1);

		if (ans < score)
			ans = score;

		// 물고기 이동
		for (int now = 0; now < 16; now++) {
			// 잡아먹힘
			if (fish[now][0] == -1)
				continue;

			// 현재 물고기의 정보
			int r = fish[now][0];
			int c = fish[now][1];
			int d = fish[now][2];

			// 물고기가 이동할 위치와 방향
			int nr = r + dr[d];
			int nc = c + dc[d];
			int nd = d;

			// 이동할 수 없는 경우(밖 or 상어)
			while (!isRange(nr, nc) || (nr == shark[0] && nc == shark[1])) {
				nd = (nd + 1) == 8 ? 0 : nd + 1;
				nr = r + dr[nd];
				nc = c + dc[nd];
			}

			// 물고기가 없는 경우
			if (map[nr][nc] == -1) {
				map[nr][nc] = now; // 현재 물고기를 이동
				map[fish[now][0]][fish[now][1]] = -1; // 비워둠

				// 현재 물고기 정보 갱신
				fish[now][0] = nr;
				fish[now][1] = nc;
				fish[now][2] = nd;
			}
			// 물고기가 있는 경우
			else {
				int other = map[nr][nc]; // 다른 물고기의 번호
				map[nr][nc] = now; // 현재 물고기를 이동
				map[r][c] = other; // 다른 물고기 이동

				// 현재 물고기 정보 갱신
				fish[now][0] = nr;
				fish[now][1] = nc;
				fish[now][2] = nd;

				// 다른 물고기 정보 갱신
				fish[other][0] = r;
				fish[other][1] = c;
			}
		}

		// 상어 이동(1~3칸 이동 가능)
		for (int step = 0; step < 3; step++) {
			shark[0] += dr[shark[2]];
			shark[1] += dc[shark[2]];

			if (!isRange(shark[0], shark[1]))
				break;

			if (map[shark[0]][shark[1]] != -1) {
				solve(map, fish, shark, score);
			}
		}
	}

	private static boolean isRange(int nr, int nc) {
		return 0 <= nr && nr < 4 && 0 <= nc && nc < 4;
	}
}