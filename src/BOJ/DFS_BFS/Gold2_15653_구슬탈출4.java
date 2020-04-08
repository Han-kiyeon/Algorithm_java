package BOJ.DFS_BFS;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 구슬탈출2 {
	static int N, M;
	static char[][] map;
	static boolean[][][][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		int[] R = new int[2];
		int[] B = new int[2];
		int[] O = new int[2];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				// '.' 빈 칸, '#' 벽, 'O' 구멍의 위치.
				// 'R' 빨간 구슬의 위치, 'B' 파란 구슬의 위치
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					R[0] = i;
					R[1] = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					B[0] = i;
					B[1] = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'O') {
					O[0] = i;
					O[1] = j;
//					System.out.println(Arrays.toString(O));
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();
		visit = new boolean[N][M][N][M];
		int count = 0;

		q.offer(new int[] { R[0], R[1], B[0], B[1], count });
		visit[R[0]][R[1]][B[0]][B[1]] = true;

		int[] r = new int[2];
		int[] b = new int[2];

		int ans = -1;
		while (!q.isEmpty()) {
//			System.out.println(Arrays.toString(q.peek()));
			R[0] = q.peek()[0];
			R[1] = q.peek()[1];
			B[0] = q.peek()[2];
			B[1] = q.peek()[3];
			count = q.peek()[4];
			q.poll();

			// 도착 : 빨간공만 구멍에 빠짐.
			if (R[0] == O[0] && R[1] == O[1]) {
//				System.out.println("!!!!!!!!!     " + count);
				ans = count;
				break;
			}

			// 파란공만 구멍에 빠짐.
			if (B[0] == O[0] && B[1] == O[1]) {
				continue;
			}
			// 10회 초과
			if (count == 10)
				continue;

			for (int k = 0; k < dr.length; k++) {
				boolean flag = false;
				switch (k) {
				case 0: // 상
					if (R[0] < B[0])
						flag = true;
					break;
				case 1: // 하
					if (R[0] > B[0])
						flag = true;
					break;
				case 2: // 좌
					if (R[1] < B[1])
						flag = true;
					break;
				case 3: // 우
					if (R[1] > B[1])
						flag = true;
					break;
				}

				// flag가 참이면 빨간공 먼저 움직임
				if (flag) {
					r[0] = R[0] + dr[k];
					r[1] = R[1] + dc[k];
					while (map[r[0]][r[1]] == '.') {
						r[0] += dr[k];
						r[1] += dc[k];
					}
					if (map[r[0]][r[1]] == '#') {
						r[0] -= dr[k];
						r[1] -= dc[k];
					}

					b[0] = B[0] + dr[k];
					b[1] = B[1] + dc[k];
					while (map[b[0]][b[1]] == '.') {
						if (b[0] == r[0] && b[1] == r[1]) {
							b[0] -= dr[k];
							b[1] -= dc[k];
							break;
						}
						b[0] += dr[k];
						b[1] += dc[k];
					}
					if (map[b[0]][b[1]] == '#') {
						b[0] -= dr[k];
						b[1] -= dc[k];
					}
				} else { // flag가 거짓이면 파란공 먼저 움직임.
					b[0] = B[0] + dr[k];
					b[1] = B[1] + dc[k];
					while (map[b[0]][b[1]] == '.') {
						b[0] += dr[k];
						b[1] += dc[k];
					}
					if (map[b[0]][b[1]] == '#') {
						b[0] -= dr[k];
						b[1] -= dc[k];
					}

					r[0] = R[0] + dr[k];
					r[1] = R[1] + dc[k];
					while (map[r[0]][r[1]] == '.') {
						if (b[0] == r[0] && b[1] == r[1]) {
							r[0] -= dr[k];
							r[1] -= dc[k];
							break;
						}
						r[0] += dr[k];
						r[1] += dc[k];
					}
					if (map[r[0]][r[1]] == '#') {
						r[0] -= dr[k];
						r[1] -= dc[k];
					}
				}

				// 구멍에 둘다 빠짐.
				if (b[0] == r[0] && b[1] == r[1]) {
					continue;
				}

				if (!visit[r[0]][r[1]][b[0]][b[1]]) {
//					System.out.println("          " + k + " " + Arrays.toString(r) + " " + Arrays.toString(b));
					visit[r[0]][r[1]][b[0]][b[1]] = true;
					q.offer(new int[] { r[0], r[1], b[0], b[1], count + 1 });
				}
			} // end of for(move)

		} // end of while
		System.out.println(ans);
//		System.out.println("end");
	}// end of main
}