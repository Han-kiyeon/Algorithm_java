package SWEA.문제해결_기본;

import java.io.FileInputStream;
import java.util.Scanner;

public class Day01_1204_최빈수구하기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N = 1000; // 학생 수

		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();
			int[] score = new int[101]; // 0~100점

			// 1000명 점수 입력
			for (int i = 0; i < N; i++) {
				score[sc.nextInt()]++; // 점수 카운트
			}

			// 최빈값 찾기 (최빈값이 여러개일 경우 높은 점수 출력)
			int max = Integer.MIN_VALUE;
			int ans = 0;
			for (int i = 100; i >= 0; i--) { // 뒤부터 탐색
				if (max < score[i]) {
					max = score[i]; // 최빈값
					ans = i; // 최빈값의 점수(인덱스)
				}
			}

			System.out.println("#" + tc + " " + ans);
		} // end of TC
	}// end of Main
}