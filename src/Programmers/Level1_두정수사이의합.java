package Programmers;

import java.util.*;

public class Level1_두정수사이의합 {
	public static void main(String[] args) {
		System.out.println(solution(3, 5));// 12
	}

	public static long solution(int a, int b) {
		long answer = 0;
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		// return (b - a + 1) * (a + b) / 2;
		for (int i = a; i <= b; i++) {
			answer += i;
		}
		return answer;
	}
}