package BOJ.Simulation;
import java.util.*;
import java.io.*;

public class Gold2_17825_주사위윷놀이 {
	static int answer;
	static int data[] = new int[10];
	static int list[] = new int[10];
	static int map[][] = {
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },
			{ 10, 13, 16, 19, 25, 30, 35, 40 },
			{ 20, 22, 24, 25, 30, 35, 40 },
			{ 30, 28, 27, 26, 25, 30, 35, 40 },
			{ 25, 30, 35, 40 }
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 10; i++)
			data[i] = Integer.parseInt(st.nextToken());

		answer = 0;
		go(0);
		System.out.println(answer);
	}

	static void go(int v) {
		if (v == 10) {
			int ret = Test();
			if (answer < ret)
				answer = ret;
			return;
		}

		for (int i = 0; i < 4; i++) {
			list[v] = i;
			go(v + 1);
		}
	}

	static int Test() {
		int ret = 0;
		// 4개의 말이 있다.
		int horse[][] = new int[4][2]; // 맵번호와 위치를 저장
		for (int i = 0; i < 10; i++) {
			int cur = list[i]; // 옮길 말의 번호
			int move = data[i];// 얼마나 움직일지

			// 이미 도착한 말을 이동하려하면 종료
			if (horse[cur][1] == -1)
				return 0;

			// 옮긴 위치가 도착점이 아닐 때(맵을 벗어난 경우는 도착을 의미)
			if (horse[cur][1] + move < map[horse[cur][0]].length) {
				// 이동
				horse[cur][1] += move;

				// 맵 분기
				int idx = horse[cur][0]; // 맵 번호
				int pos = horse[cur][1]; // 위치
				if (idx == 0) { // 맵 번호가 0일때 분기 가능한 위치들
					if (map[0][pos] == 10) {
						horse[cur][0] = 1;
						horse[cur][1] = 0;
					} else if (map[0][pos] == 20) {
						horse[cur][0] = 2;
						horse[cur][1] = 0;
					} else if (map[0][pos] == 30) {
						horse[cur][0] = 3;
						horse[cur][1] = 0;
					} else if (map[0][pos] == 40) {
						horse[cur][0] = 4;
						horse[cur][1] = 3;
					}
				} else if (idx != 4) { // 맵 번호가 1, 2, 3번일 때
					for (int j = 0; j < map[4].length; j++) {
						if (map[idx][pos] == map[4][j]) {
							horse[cur][0] = 4;
							horse[cur][1] = j;
							break;
						}
					}
				}

				// 다른 말이 있는지 검사하기.
				for (int j = 0; j < 4; j++) {
					int[] other = horse[j];
					// 같은 말, 도착, 출발 안함.
					if (cur == j || other[1] == -1 || map[other[0]][other[1]] == 0)
						continue;
					// 옮긴 위치가 다른 말의 위치랑 같을 때
					if (horse[cur][0] == other[0] && horse[cur][1] == other[1])
						return 0;
				}

				// 이상 없다면 점수 누적
				ret += map[horse[cur][0]][horse[cur][1]];
			}
			// 도착
			else
				horse[cur][1] = -1;
		}
		return ret;
	}
}