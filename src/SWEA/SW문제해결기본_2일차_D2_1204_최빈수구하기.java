package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA.Math
 * @FileName : SW문제해결기본_2일차_D2_1204_최빈수구하기.java
 *
 * @Date : 2019. 08. 26.
 * @작성자 : 한기연
 * @메모리 : 52,420 kb
 * @실행시간 : 202 ms
 *
 * @Blog : __
 **/

public class SW문제해결기본_2일차_D2_1204_최빈수구하기 {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		for (int i = 1; i <= N; i++) { // testCase 만큼 순회
			int tc = s.nextInt(); // testCase number
			int[] array = new int[1000]; // 학생수 1000명
			int[] countarray = new int[101]; // 0~100점

			// 1000명 점수 입력
			for (int j = 0; j < array.length; j++) {
				array[j] = s.nextInt(); // 학생 점수 입력
				countarray[array[j]]++; // 점수 카운트
			}

			// 최빈값 찾기 (최빈값이 여러개일 경우 높은 점수 출력)
			int max = Integer.MIN_VALUE, idx = 0;

			for (int k = countarray.length - 1; k > 0; k--) { // 뒤부터 탐색
				if (max < countarray[k]) {
					max = countarray[k]; // 최빈값
					idx = k; // 최빈값의 점수(인덱스)
				}
			}

			// 결과 출력
			System.out.println("#" + tc + " " + idx);
		}
		s.close();
	}
}