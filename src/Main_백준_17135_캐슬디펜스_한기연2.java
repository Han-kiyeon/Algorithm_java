import java.io.*;
import java.util.*;

public class Main_백준_17135_캐슬디펜스_한기연2 {
	public static int[] dx = { 0, -1, 0 };
	public static int[] dy = { -1, 0, 1 };
	public static int n, m, d, ans = 0;
	public static boolean[] visit; // nCr 구할 때 사용하는 배열
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m];
		visit = new boolean[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		nCr(0, 0);
		System.out.println(ans);
	}

	// m개의 자리중 3개의 궁수 자리 선택
	public static void nCr(int idx, int depth) {
		if (depth == 3) {
			int[][] nmap = new int[n + 1][m];
			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < m; j++) {
					nmap[i][j] = map[i][j];
				}
			}
			bfs(nmap);
			return;
		}
		for (int i = idx; i < m; i++) {
			if (!visit[i]) {
				visit[i] = true;
				nCr(i, depth + 1);
				visit[i] = false;
			}
		}
	}

	public static void bfs(int[][] nmap) {
		int cnt = 0;
		for (int i = n; i > 0; i--) { // 궁수의 포지션을 한칸씩 앞으로 이동
			int archerIdx = 0;
			Queue<Pair> q = new LinkedList<>();
			for (int j = 0; j < m; j++) {
				// nmap에서 궁수 위치는 2
				if (visit[j]) {
					nmap[i][j] = 2;
					q.add(new Pair(i - 1, j, 1, archerIdx++));
				} else { // 궁수 위치가 아니면 0
					nmap[i][j] = 0;
				}
			}

			boolean[] isEnemyFind = new boolean[3]; // 각 궁수가 몬스터를 찾았는지
			boolean[][][] visited = new boolean[n][m][3]; // 각 궁수가 해당 좌표를 방문했는지
			boolean[][] isAlreadyFindLocation = new boolean[n][m]; // 이미 다른 궁수가 찾은 목표물인지
			ArrayList<Pair> alist = new ArrayList<>();

			while (!q.isEmpty()) {
				Pair p = q.poll();
				if (isEnemyFind[p.idx])
					continue;
				if (nmap[p.x][p.y] == 1) {
					isEnemyFind[p.idx] = true;
					if (!isAlreadyFindLocation[p.x][p.y]) {
						isAlreadyFindLocation[p.x][p.y] = true;
						alist.add(p);
						cnt++;
					}
					continue;
				}
				if (!isEnemyFind[p.idx]) {
					visited[p.x][p.y][p.idx] = true;
					for (int j = 0; j < 3; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
						if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][p.idx]
								&& p.depth < d) {
							q.add(new Pair(nx, ny, p.depth + 1, p.idx));
						}
					}
				}
			}
			for (int j = 0; j < alist.size(); j++) {
				Pair p = alist.get(j);
				nmap[p.x][p.y] = 0;
			}
		}
		ans = Math.max(ans, cnt);
	}

	public static class Pair {
		int x, y, depth, idx;

		public Pair(int x, int y, int depth, int idx) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.idx = idx;
		}
	}
}
