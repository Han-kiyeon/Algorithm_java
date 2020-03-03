package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : 모의SW역량테스트_2115_벌꿀채취.java
 *
 * @Date : 2020. 2. 28.
 * @작성자 : 한기연
 * @메모리 : 20,296 kb
 * @실행시간 : 115 ms
 *
 * @Blog : __
 **/
public class 모의SW역량테스트_2115_벌꿀채취 {
	static int N, M, C; // N : 벌통크기, M : 연속된 벌통수, C: 채취량
	static int[][] map, maxMap; // map : 입력된 벌통정도, maxMap : i,j 위치에서 가질 수 있는 최대 이익

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 1. 각 위치에서의 최대이익
			makeMaxMap();

			// 2. 두 일꾼의 조합
			System.out.println("#" + tc + " " + getMaxBenefit());
		}
	}

	private static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}

	// i: 행의 위치, j: 열의 위치, cnt: 고려한원소수
	// sum: 부분집합에 속한 원소의 합, powSum: 부분집합에 속한 원소의 이익
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		if (sum > C)
			return;
		if (cnt == M) {
			// 0,0 M=2
			if (maxMap[i][j - M] < powSum) {
				maxMap[i][j - M] = powSum;
			}
			return;
		}

		// i,j 위치의 원소를 선택
		makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j] * map[i][j]);

		// 비선택
		makeMaxSubset(i, j + 1, cnt + 1, sum, powSum);
	}

	private static int getMaxBenefit() {
		int max = 0, temp = 0; // max: 조합적 선택후의 최대이익값
		// 1. 일꾼A 기준선택
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) { // a일꾼
				// 2. 일꾼 B 선택
				// 같은 행기준 선택
				for (int j2 = j + M; j2 <= N - M; j2++) {
					temp = maxMap[i][j] + maxMap[i][j2]; // 두 일꾼 조합의 최대이익
					if (max < temp) {
						max = temp;
					}
				}
				// 다음행부터 마지막행까지 선택
				for (int i2 = i + 1; i2 < map.length; i2++) {
					for (int j2 = 0; j2 <= N - M; j2++) {
						temp = maxMap[i][j] + maxMap[i2][j2];
						if (max < temp) {
							max = temp;
						}
					}
				}
			}
		}

		return max;
	}
}