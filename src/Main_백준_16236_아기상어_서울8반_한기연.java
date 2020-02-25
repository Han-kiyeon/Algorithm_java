import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_16236_아기상어_서울8반_한기연 {
	static int N, time;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Shark s;

	static class Shark {
		int size, r, c, count;

		@Override
		public String toString() {
			return "Shark [size=" + size + ", r=" + r + ", c=" + c + ", count=" + count + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 0: 빈 칸
		// 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
		// 9: 아기 상어의 위치
		map = new int[N][N];
		s = new Shark();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				map[i][j] = tmp;
				if (tmp == 9) {
					s.r = i;
					s.c = j;
					s.size = 2;
					s.count = 0;
				}
			}
		}
		time = 0;
		while (move(s)) {
			//System.out.println("======================");
		}
		System.out.println(time);

	}

	private static boolean move(Shark s) {
//		System.out.println(s);
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
//		System.out.println();

		boolean[][] visit = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>();
		q.offer(new int[] { s.r, s.c, 0 });
		visit[s.r][s.c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dr[k];
				int c = cur[1] + dc[k];

				if (range(r, c) && !visit[r][c]) {
					visit[r][c] = true;
					if (map[r][c] > s.size)// 지나가지도 먹지도 못함
						continue;
					else if (map[r][c] == s.size || map[r][c] == 0) // 지나갈순 있지만 먹진 못함.
						q.offer(new int[] { r, c, cur[2] + 1 });
					else {
						list.add(new int[] { r, c, cur[2] + 1 });
					}
				}
			}
		} // end of while

		if (list.isEmpty())
			return false;
		else {
			Collections.sort(list, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					int r = o1[2] - o2[2]; // 거리순으로
					if (r == 0) {// 위쪽 우선순위
						int r2 = o1[0] - o2[0];
						if (r2 == 0) {// 왼쪽 우선순위
							return o1[1] - o2[1];
						} else
							return r2;
					} else
						return r;
				}
			});
//			for (int[] is : list) {
//				System.out.println(Arrays.toString(is));
//			}
			eat(list.get(0));
			return true;
		}

	}

	private static void eat(int[] fish) {
		//System.out.println("<eat>" + fish[0] + " : " + fish[1]);
		time += fish[2];
		//System.out.println("time= " + time);
		map[s.r][s.c] = 0;
		s.r = fish[0];
		s.c = fish[1];
		s.count++;
		if (s.count == s.size) {
			s.size++;
			s.count = 0;
		}
		map[fish[0]][fish[1]] = 9;
	}

	private static boolean range(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < N)
			return true;
		return false;
	}
}
