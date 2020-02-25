import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main_백준_9376_탈옥_서울8반_한기연3 {
	static int h, w;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class People {
		int x, y, cnt;
		ArrayList<int[]> door;

		public People(int x, int y, int cnt, ArrayList<int[]> door) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.door = door;
		}
	}

	static boolean range(int x, int y) {
		if (0 <= x && x < h && 0 <= y && y < w)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/백준_9376_탈옥.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			int[][] map = new int[h][w];
			boolean[][] visit1 = new boolean[h][w];
			boolean[][] visit2 = new boolean[h][w];
			Queue<People> q1 = new LinkedList<>();
			Queue<People> q2 = new LinkedList<>();

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					char tmp = str.charAt(j);
					if (tmp == '$') {// 죄수
						if (q1.isEmpty()) {
							q1.offer(new People(i, j, 0, new ArrayList<>())); // 좌표(x,y), 움직인거리, 열린문
							visit1[i][j] = true;
						} else {
							q2.offer(new People(i, j, 0, new ArrayList<>()));
							visit2[i][j] = true;
						}
						tmp = '.';
					}
					map[i][j] = tmp;
				}
			}
			ArrayList<ArrayList<int[]>> res1 = new ArrayList<>();
			while (!q1.isEmpty()) {
				People cur = q1.poll();
				if (cur.x == 0 || cur.x == h - 1 || cur.y == 0 || cur.y == w - 1) {
					if (cur.door.isEmpty()) {
						ArrayList<int[]> tmp = new ArrayList<>();
						tmp.add(new int[] { -1, -1 });
						res1.add(tmp);
					} else
						res1.add(cur.door);
				}
				for (int k = 0; k < 4; k++) {
					int x = cur.x + dx[k];
					int y = cur.y + dy[k];
					if (range(x, y) && !visit1[x][y])
						if (map[x][y] == '.') { // 길
							visit1[x][y] = true;
							q1.offer(new People(x, y, cur.cnt + 1, cur.door));
						} else if (map[x][y] == '#') {// 문
							visit1[x][y] = true;
							cur.door.add(new int[] { x, y });
							q1.offer(new People(x, y, cur.cnt + 1, cur.door));
						}
				}
			}
			ArrayList<ArrayList<int[]>> res2 = new ArrayList<>();
			while (!q2.isEmpty()) {
				People cur = q2.poll();
				if (cur.x == 0 || cur.x == h - 1 || cur.y == 0 || cur.y == w - 1) {
					if (cur.door.isEmpty()) {
						ArrayList<int[]> tmp = new ArrayList<>();
						tmp.add(new int[] { -1, -1 });
						res2.add(tmp);
					} else
						res2.add(cur.door);
				}
				for (int k = 0; k < 4; k++) {
					int x = cur.x + dx[k];
					int y = cur.y + dy[k];
					if (range(x, y) && !visit2[x][y])
						if (map[x][y] == '.') { // 길
							visit2[x][y] = true;
							q2.offer(new People(x, y, cur.cnt + 1, cur.door));
						} else if (map[x][y] == '#') {// 문
							visit2[x][y] = true;
							cur.door.add(new int[] { x, y });
							q2.offer(new People(x, y, cur.cnt + 1, cur.door));
						}
				}
			}

			System.out.println("res1");
			for (ArrayList<int[]> list : res1) {
				for (int[] l : list)
					System.out.println(Arrays.toString(l));
				System.out.println();
			}

			System.out.println("res2");
			for (ArrayList<int[]> list : res2) {
				for (int[] l : list)
					System.out.println(Arrays.toString(l));
				System.out.println();
			}

			int res = 0;
			System.out.println(res);
		} // end of TC
	}// end of main
}
