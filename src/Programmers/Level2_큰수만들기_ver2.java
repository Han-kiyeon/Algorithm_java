package Programmers;

import java.util.Stack;

class Level2_큰수만들기_ver2 {
	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
		System.out.println(solution("1000", 2));
	}

	public static String solution(String number, int k) {
		Stack<Character> stack = new Stack<>();
		int len = number.length() - k; // 반환하는 문자열의 길이

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);

			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(stack.get(i));
		}
		return sb.toString();
	}
}
