package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D4_8275_햄스터.java
 *
 * @Date : 2020. 3. 4.
 * @작성자 : 한기연
 * @메모리 : 34,304 kb
 * @실행시간 : 697 ms
 *
 * @Blog : __
 **/
public class D4_8275_햄스터 {
	static int[] cage;
	static int N, X, M;
	static int[][] input;
	static int max;
	static StringBuilder ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt(); // 우리 갯수
			X = sc.nextInt(); // 최대 마리수
			M = sc.nextInt(); // 입력 데이터의 횟수

			cage = new int[N];
			input = new int[M][3]; // left, right, sum

			for (int i = 0; i < M; i++) {
				input[i][0] = sc.nextInt() - 1; // left
				input[i][1] = sc.nextInt() - 1; // right
				input[i][2] = sc.nextInt(); // sum
			}
			max = -1;
			solve(0, 0);
			System.out.println("#" + tc + " " + ((max == -1) ? max : ans));
		}

	}

	private static void solve(int idx, int sum) {
		if (idx == N) { // 우리의 끝까지 탐색
			if (check()) { // 조건 판단
				if (max < sum) {
					max = sum;
					ans = new StringBuilder();
					for (int i = 0; i < N; i++) {
						ans.append(cage[i]).append(" ");
					}
				}
			}
			return;
		}
		for (int i = 0; i <= X; i++) {
			cage[idx] = i;
			solve(idx + 1, sum + i);
		}
	}

	private static boolean check() {
		for (int k = 0; k < M; k++) {
			int tmp = 0;
			for (int i = input[k][0]; i <= input[k][1]; i++) {
				tmp += cage[i];
			}
			if (tmp != input[k][2])
				return false;
		}
		return true;
	}

}