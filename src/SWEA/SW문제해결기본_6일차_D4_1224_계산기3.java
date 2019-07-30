package SWEA;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_6일차_D4_1224_계산기3.java
 *
 * @Date : 2019. 7. 30.
 * @작성자 : 한기연
 * @메모리 : 26,728 kb
 * @실행시간 : 142 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_6일차_D4_1224_계산기3 {
	public static Stack<Integer> is = new Stack<>();
	public static Stack<Character> cs = new Stack<>();

	public static int calc(String msg) {
		for (int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			if ('0' <= c && c <= '9')
				is.push(c - '0');
			else {
				int n2 = is.pop();
				int n1 = is.pop();
				int nn = 0;

				switch (c) {
				case '+':
					nn = n1 + n2;
					break;
				case '-':
					nn = n1 - n2;
					break;
				case '*':
					nn = n1 * n2;
					break;
				case '/':
					nn = n1 / n2;
					break;
				}

				is.push(nn);
			}
		}
		return is.pop();
	}

	public static int getIcp(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 3;
		default:
			return 0;
		}
	}

	public static int getIsp() {
		// ' '>> 특별한의미 없음 0을 리턴하기 위해서
		char c = (cs.empty()) ? ' ' : cs.peek();
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		default:
			return 0;
		}
	}

	public static String in2Post(String msg) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			if ('0' <= c && c <= '9')
				sb.append(c);
			else if (c == ')') {
				char s;
				while ((s = cs.pop()) != '(')
					sb.append(s);

			} else if (c == ' ')
				continue;
			else {
				while (getIcp(c) <= getIsp())
					sb.append(cs.pop());
				cs.push(c);
			}
		}

		while (!cs.empty())
			sb.append(cs.pop());

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/1224_D4_계산기3.txt"));
		Scanner s = new Scanner(System.in);
		// A(0)->B(99)로 가는길 찾기
		int T = 10; // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			s.next(); // 테스트 케이스 길이
			System.out.println("#" + tc + " " + calc(in2Post(s.next())));
		}

		s.close(); // Scanner close
	}
}