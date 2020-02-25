package com.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행_한기연2 {
	private static char[][] map;
	private static int[] visited;
	private static int max;
	private static int R;
	private static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken()); // 1 <= R,C <= 20
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray(); // 1차원 배열을 통째로 받기
//              }
			}

			visited = new int['Z' + 1]; // 방문 여부를 체크하는 배열. 65A~90Z 인덱스만 사용(앞에는 그냥 버림).
													// A:65, Z:90
//          0,0 부터 시작해서 DFS로 탐색
			visited[map[0][0]]++; // 방문 체크
			max = 1; // 최대 전진할 수 있는 칸 수를 저장

			dfs(0, 0, 1);

			sb.append('#').append(tc).append(' ').append(max).append('\n');
		} // end of for-tc
		System.out.print(sb);
	} // end of main
	/* (r,c) step칸 수 만큼 진행한 상태 */

	public static void dfs(int r, int c, int step) {
//      반복문 : 같은 구조면 재귀함수보다 반복문이 더 빠르다.
//      재귀함수    : 깊이우선, 너비우선, 가지치기 등 원하는 알고리즘을 자유롭게 사용할 수 있다는 장점이 있다.
//      가지치기    : 백트래킹의 포커스는 가지치기다. 몇 줄 추가로 시간을 크게 줄일 수 있다.
		if (max == 26)
			return;
		if (max < step)
			max = step; // 최대칸수이면 업데이트
		// 상하좌우
		if (0 <= r - 1 && visited[map[r - 1][c]] == 0) { // 상
//          방문여부 체크
			visited[map[r - 1][c]]++;

//          깊이우선 재귀호출
			dfs(r - 1, c, step + 1);

//          방문여부 체크 해제
			visited[map[r - 1][c]]--;
		}

		if (r + 1 < R && visited[map[r + 1][c]] == 0) { // 하
			visited[map[r + 1][c]]++;
			dfs(r + 1, c, step + 1);
			visited[map[r + 1][c]]--;
		}

		if (0 <= c - 1 && visited[map[r][c - 1]] == 0) { // 좌
			visited[map[r][c - 1]]++;
			dfs(r, c - 1, step + 1);
			visited[map[r][c - 1]]--;
		}

		if (c + 1 < C && visited[map[r][c + 1]] == 0) { // 우
			visited[map[r][c + 1]]++;
			dfs(r, c + 1, step + 1);
			visited[map[r][c + 1]]--;

		}
	}
} // end of class
