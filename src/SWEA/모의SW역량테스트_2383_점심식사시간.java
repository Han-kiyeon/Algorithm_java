package SWEA;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : 모의SW역량테스트_2383_점심식사시간.java
 *
 * @Date : 2019. 11. 15.
 * @작성자 : 한기연
 * @메모리 : 36,012 kb
 * @실행시간 : 177 ms
 *
 * @Blog : __
 **/
class Point { // 방에서의 위치를 나타내는 클래스
	int r, c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "(" + r + ", " + c + ")";
	}

}

public class 모의SW역량테스트_2383_점심식사시간 {
	static int MAXM = 11;
	static int MAXT = 11 * 2 + 11 * 11;
	static int N;
	static int match[];
	static int M, S;
	static int answer;
	static Point[] man;
	static Point[] stair;
	static int[] length;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = 0; // 사람 수
			S = -1; // 계단 수
			man = new Point[10]; // 최대 사람은 10명(위치 좌표를 저장)
			stair = new Point[2]; // 계단은 2개(위치 좌표를 저장)
			length = new int[2];// 계단의 길이 저장
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int tmp = sc.nextInt();
					if (tmp == 1)
						man[M++] = new Point(i, j);
					else if (tmp != 0) {
						stair[++S] = new Point(i, j);
						length[S] = tmp;
					}
				}
			}
			answer = Integer.MAX_VALUE;
			match = new int[M];
			dfs(0); // 모든 경우의 수를 구한다.
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}

	// 중복순열: 모든 경우의 수를 구한다 최대 2^10
	private static void dfs(int depth) {

		if (depth == M) {
			solve();
			return;
		}
		for (int i = 0; i < 2; i++) {
			match[depth] = i;
			dfs(depth + 1);
		}
	}

	// 각사람이 어느 계단을 이용할 지 정해졌을 때에 필요한 시간을 계산하는 함수
	private static void solve() {
		PriorityQueue<Integer> pq0 = new PriorityQueue<>();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			if (match[i] == 0)
				pq0.add(dist(man[i], stair[0]));
			else
				pq1.add(dist(man[i], stair[1]));
		}

		////////////////////////////////////////////////////////////////////////////

		int man = M; // 남은 이용자.
		int[] stair0 = new int[3]; // 계단을 이용하는 사람들의 남은 이용시간.
		int[] stair1 = new int[3];
		// System.out.println("man: " + man);

		int time = 0;
		while (true) { // 계단을 모든 이용자가 이용할 때 까지.

			if (man == 0) {
				boolean flag = true;
				for (int i = 0; i < 3; i++) {
					if (stair0[i] != 0) {
						flag = false;
						break;
					}
					if (stair1[i] != 0) {
						flag = false;
						break;
					}
				}
				if (flag)
					break;
			}
			for (int i = 0; i < 3; i++) { // 계단은 최대 3명까지 동시에 이용할 수 있다.
				if (stair0[i] == 0) { // 현재 이용하는 사람이 없을때
					if (!pq0.isEmpty()) { // 이용할 사람이 있고(큐가 비어있지 않다면)
						if (pq0.peek() <= time) { // 도착했다면
							man--; // 남은 이용자수를 내린다.
							stair0[i] = length[0];// 해당 계단의 이동시간을 주고
							pq0.poll();
						}
					}
				} else { // 현재 계단을 사용하고 있다면
					stair0[i]--; // 값을 내리고
					if (stair0[i] == 0) {// 계단을 이용하고 있지 않다면.
						if (!pq0.isEmpty()) {
							if (pq0.peek() <= time) {
								man--; // 이용자를 내린다.
								stair0[i] = length[0];
								pq0.poll();
							}
						}
					}
				}

				if (stair1[i] == 0) { // 현재 이용하는 사람이 없을때
					if (!pq1.isEmpty()) { // 이용할 사람이 있고(큐가 비어있지 않다면)
						if (pq1.peek() <= time) { // 도착했다면
							man--; // 남은 이용자수를 내린다.
							stair1[i] = length[1];// 해당 계단의 이동시간을 주고
							pq1.poll();
						}
					}
				} else { // 현재 계단을 사용하고 있다면
					stair1[i]--; // 값을 내리고
					if (stair1[i] == 0) {// 계단을 이용하고 있지 않다면.
						if (!pq1.isEmpty()) {
							if (pq1.peek() <= time) {
								man--; // 이용자를 내린다.
								stair1[i] = length[1];
								pq1.poll();
							}
						}
					}
				}

			} // end of for
			time++;
		} // end of while
			// System.out.println("result= " + time);
		if (time < answer)
			answer = time;
	}

	private static int dist(Point man, Point stair) {
		return Math.abs(man.r - stair.r) + Math.abs(man.c - stair.c);
	}

}