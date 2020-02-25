package com.d3;

import java.io.*;
import java.util.*;

/*
 * [문제] 
 * 숫자 체계가 우리와 다른 어느 행성이 있다. 아래는 이 행성에서 사용하는 0 ~ 9의 값을 순서대로 나타낸 것이다. 
 * "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" 
 * 0 ~ 9 의 값을 나타내는 단어가 섞여 있는 문자열을 받아 작은 수부터 차례로 정렬하여 출력하는 프로그램을 작성하라.
 * 예를 들어 입력 문자열이 "TWO NIN TWO TWO FIV FOR" 일 경우 정렬한 문자열은
 * "TWO TWO TWO FOR FIV NIN" 이 된다.
 * 
 * [입력] 
 * 입력 파일의 첫 번째 줄에는 테스트 케이스의 개수가 주어진다. 
 * 그 다음 줄에 #기호와 함께 테스트 케이스의 번호가 주어지고
 * 공백문자 후 테스트 케이스의 길이가 주어진다. 
 * 그 다음 줄부터 바로 테스트 케이스가 주어진다. 
 * 단어와 단어 사이는 하나의 공백으로 구분하며, 문자열의 길이 N은 100≤N≤10000이다.
 * 
 * [출력] 
 * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 정렬된 문자열을 출력한다.
 */
public class Solution_D3_1221_GNS_한기연 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1221_D3_GNS.txt"));
		Scanner s = new Scanner(System.in);

		int T = s.nextInt(); // TC의 개수

		// System.out.println(T);

		for (int tc = 1; tc <= T; tc++) {
			System.out.println(s.next()); // 테스트 케이스 번호
			int N = s.nextInt(); // 테스트 케이스의 길이
			// System.out.println(N);
			int[] cntArr = new int[10];
			for (int i = 0; i < N; i++) {
				switch (s.next()) {
				case "ZRO":	cntArr[0]++; break;
				case "ONE":	cntArr[1]++; break;
				case "TWO":	cntArr[2]++; break;
				case "THR":	cntArr[3]++; break;
				case "FOR":	cntArr[4]++; break;
				case "FIV":	cntArr[5]++; break;
				case "SIX":	cntArr[6]++; break;
				case "SVN":	cntArr[7]++; break;
				case "EGT":	cntArr[8]++; break;
				case "NIN":	cntArr[9]++; break;
				}
			}
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < cntArr[i]; j++) {
					switch (i) {
					case 0: System.out.print("ZRO "); break;
					case 1: System.out.print("ONE "); break;
					case 2: System.out.print("TWO "); break;
					case 3: System.out.print("THR "); break;
					case 4: System.out.print("FOR "); break;
					case 5: System.out.print("FIV "); break;
					case 6: System.out.print("SIX "); break;
					case 7: System.out.print("SVN "); break;
					case 8: System.out.print("EGT "); break;
					case 9: System.out.print("NIN "); break;
					}
				}
			System.out.println();
		}

		s.close();

	}

}