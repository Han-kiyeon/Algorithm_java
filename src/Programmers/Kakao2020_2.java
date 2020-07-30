package Programmers;

import java.util.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Kakao2020_2 {

	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
		System.out.println(solution("50*6-3*2"));
	}

	static char[] operator = { '+', '-', '*' };
	static boolean[] visit;
	static char[] ret;
	static long answer;
	static LinkedList<String> input;

	private static long solution(String expression) {
		StringTokenizer st = new StringTokenizer(expression, "+-*");
		input = new LinkedList<>();
		while (st.hasMoreTokens()) {
			input.add(st.nextToken());
		}
		st = new StringTokenizer(expression, "0123456789");
		int i = 1;
		while (st.hasMoreTokens()) {
			input.add(i, st.nextToken());
			i += 2;
		}
		System.out.println(input);
		visit = new boolean[3];
		ret = new char[3];
		answer = 0;
		solve(0, 0);// 순열을 이용한 전수조사.
		return answer;
	}

	private static void solve(int index, int depth) {
		if (depth == 3) {
			long tmp = check();
			if (answer < tmp) {
				answer = tmp;
			}
			return;
		}
		for (int i = 0; i < operator.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				ret[depth] = operator[i];
				solve(i, depth + 1);
				visit[i] = false;
			}
		}

	}

	private static long check() {
		LinkedList<String> copy = new LinkedList<>(input);// static로 선언된 input의 메모리공간 공유 >> 복사함
		for (char op1 : ret) {
			for (int i = 0; i < copy.size(); i++) {
				if (copy.get(i).charAt(0) == op1) {
					long A = Long.parseLong(copy.get(i - 1));
					long B = Long.parseLong(copy.get(i + 1));

					if (op1 == '+')
						A += B;
					else if (op1 == '-')
						A -= B;
					else
						A *= B;
					copy.remove(i - 1);
					copy.remove(i - 1);
					copy.remove(i - 1);
					copy.add(i - 1, "" + A);
					i--;
				}
			}
		}
		return Math.abs((Long.parseLong(copy.get(0))));
	}
}
