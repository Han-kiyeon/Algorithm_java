//[문제]
//삼성 1:1 프로그래밍 리그의 시즌이 끝났다. 앨리스는 B전 A승, 
//밥은 D전 C승이다. 누구의 승률이 더 높은가?

//[입력]
//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//각 테스트 케이스의 첫 번째 줄에는 네 자연수 
//A, B, C, D(1 ≤ A ≤ B ≤ 100,1 ≤ C ≤ D ≤ 100)이 공백로 구분되어 주어진다.

//[출력]
//각 테스트 케이스마다 앨리스의 승률이 더 높으면 “ALICE”, 밥의 승률이 더 높으면 “BOB”,
//둘의 승률이 같으면 “DRAW”를 출력한다.

//[힌트]
//첫 번째 Testcase를 예로 들면 엘리스는 2전 1승, 밥은 4전 2승이다.
//엘리스의 승률은 1/2 밥의 승률은 2/4로 서로 같으므로 “DRAW”를 출력한다.

package com.d3;

import java.io.*;
import java.util.*;

public class Solution_D3_3975_승률비교하기 {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/_________.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			double a, b, c, d;
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Double.parseDouble(st.nextToken());
			b = Double.parseDouble(st.nextToken());
			c = Double.parseDouble(st.nextToken());
			d = Double.parseDouble(st.nextToken());
			
			System.out.print("#" + tc + " ");
			if ((a / b) > (c / d))
				System.out.println("ALICE");
			else if ((a / b) < (c / d))
				System.out.println("BOB");
			else
				System.out.println("DRAW");
		}

		br.close();
	}
}
