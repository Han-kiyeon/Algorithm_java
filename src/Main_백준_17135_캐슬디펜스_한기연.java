import java.io.*;
import java.util.*;

public class Main_백준_17135_캐슬디펜스_한기연 {
	static int N, M, D, res;
	static int[][] map;
	static int[][] nmap;
	static int[] castle;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		res = -1;
		castle = new int[M];
		visit = new boolean[M];
		select(0, 0);

		System.out.println(res);
	}// end of main

	static void select(int depth, int idx) { // 3명의 궁수 위치 선정
		if (3 == depth) {
			nmap = new int[N][M];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					nmap[i][j] = map[i][j];

			int tmp = solve();
			res = (tmp > res) ? tmp : res;
			return;
		}
		for (int i = idx; i < M; i++) {
			if (!visit[i]) {
				visit[i] = true;
				castle[i] = 1;
				select(depth + 1, i);
				castle[i] = 0;
				visit[i] = false;
			}
		}
	}

	static int solve() { // 선정된 위치의 궁수가 죽일 수 있는 적의 수
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += turn();
		}
		return sum;
	}

	static int turn() { // 턴
		int cnt = 0;
		Queue<int[]> die = new LinkedList<>();
		for (int k = 0; k < M; k++)
			if (castle[k] == 1)
				die.offer(find(k)); // 궁수가 죽일수 있는 적의 좌표.

		while (!die.isEmpty()) {
			int[] cur = die.poll();
			if (cur[0] == -1)
				continue;
			if (nmap[cur[0]][cur[1]] != 2) {
				nmap[cur[0]][cur[1]] = 2; // 죽음 처리.
				cnt++;
			}
		}
		
		move();// 적 움직임.
		return cnt;
	}

	static int[] find(int k) { // 적 찾기
		int min = Integer.MAX_VALUE;
		int[] a = new int[] { -1, -1 };

		for (int j = 0; j < M; j++)
			for (int i = 0; i < N; i++)
				if (nmap[i][j] == 1) {
					int d = dis(k, i, j);
					if (d <= D)
						if (min > d) {
							min = d;
							a[0] = i;
							a[1] = j;
						}
				}

		return a;
	}

	static int dis(int k, int x, int y) { // 거리 계산
		return Math.abs(N - x) + Math.abs(k - y);
	}

	static void move() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N - 1; i++)
			tmp[i + 1] = nmap[i];
		nmap = tmp;
	}
}
