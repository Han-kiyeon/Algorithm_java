package Programmers;

import java.util.Date;

public class Level1_2016년 {
	public static void main(String[] args) {
		System.out.println(solution(5, 24));// "TUE";
	}

	public static String solution(int a, int b) {
		String[] week = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" }; // 2016년 1월 1일은 금요일
		int[] months = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int day = 0;
		for (int i = 0; i < a - 1; i++) {
			day += months[i];
		}
		day += b;

		return week[day % 7];
	}
}