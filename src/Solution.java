import java.util.Scanner;

//완전탐색: 부분집합 --> 조합
public class Solution {
	static int N, M, C; // N: 벌통크기, M:연속된벌통수, C:채취량
	static int[][] map, maxMap; // map: 입력된 벌통정보,
	// maxMap: i,j위치에서 가질수 있는 최대 이익

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			maxMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			} // end input

			// 1. 각 i,j 위치에서 연속된 M개를 고려하여 취할 수 있는 부분집합의 최대이익 계산
			makeMaxMap();
			// 2. 두 일꾼의 조합
			System.out.println("#" + tc + " " + getMaxBenefit());
		} // end of TC
	}// end of main

	private static int getMaxBenefit() {
		int max = 0, temp = 0; // max: 조합적 선택후 최대 이익값
		// 1. 일꾼A 기준선택
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M; j++) {// 일꾼A
				// 2. 일꾼B 선택
				// 같은행 기준 선택
				for (int j2 = j + M; j2 < N - M; j2++) {
					temp = maxMap[i][j] + maxMap[i][j2]; // 두 일꾼 조합의 최대이익
					if (max < temp)
						max = temp;
				}
				// 다음행부터 마지막행까지 선택
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 < N - M; j2++) {
						temp = maxMap[i][j] + maxMap[i2][j2]; // 두 일꾼 조합의 최대이익
						if (max < temp)
							max = temp;
					}
				}
			}
		}
		return max;
	}

	private static void makeMaxMap() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N - M; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}

	}// end of makeMaxMap()

	/**
	 * @param i: 행위치
	 * @param j: 열위치
	 * @param cnt: 고려한원소수
	 * @param sum: 부분집합에 속한 원소의 합
	 * @param powSum: 부분집합에 속한 원소의 이익
	 */
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		// 재귀호출 종료 조건
		if (sum > C)// 부분집합의 합이 목표량C를 초과하면 리턴
			return;
		if (cnt == M) {
			if (maxMap[i][j - M] < powSum) {
				maxMap[i][j - M] = powSum;
			}
			return;
		}

		// i, j 위치 원소 선택
		makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j] * map[i][j]);
		// i, j위치 원소 비선택
		makeMaxSubset(i, j + 1, cnt + 1, sum, powSum);
	}// end of makeMaxSubset()
}