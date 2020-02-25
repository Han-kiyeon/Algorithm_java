package JUNGOL;
import java.io.*;
import java.util.*;

public class Main_정올_1695_단지번호붙이기_BFS_서울8반_한기연 {
	static int[][] map;
	static int N, cnt;
	static int[][] visited;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		map = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if (map[i][j] == 1 && visited[i][j] == 0) {// 새로운 단지가 시작되면
					cnt = 1;
					q.offer(i);
					q.offer(j);
					visited[i][j] = 1;

					while (!q.isEmpty()) {
						int x = q.poll();
						int y = q.poll();

						for (int k = 0; k < 4; k++) {

							int nx = x + dx[k];
							int ny = y + dy[k];

							if (nx >= 0 && ny >= 0 && nx < N && ny < N)
								if (map[nx][ny] == 1 && visited[nx][ny] == 0) {// 같은 단지면.
									q.offer(nx);
									q.offer(ny);
									visited[nx][ny] = 1;
									cnt++;
								}
						}

					}
					list.add(cnt);
				}
		}

		Collections.sort(list);

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		br.close();
	}
}
