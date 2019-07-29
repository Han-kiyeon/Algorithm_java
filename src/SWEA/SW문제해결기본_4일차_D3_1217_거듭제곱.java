package SWEA;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_4일차_D3_1217_거듭제곱.java
 *
 * @Date : 2020. 7. 29.
 * @작성자 : 한기연
 * @메모리 : 26,484 kb
 * @실행시간 : 143 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_4일차_D3_1217_거듭제곱 {

	public static int N;
	public static char[] tcArr;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/1218_D4_괄호짝짓기.txt"));
		Scanner s = new Scanner(System.in);
		int T = 10; // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			int result = -1;

			N = s.nextInt();// 테스트 케이스의 길이
			tcArr = s.next().toCharArray();

			Stack<Character> stack = new Stack<>(); // 스텍 생성

			for (int i = 0; i < N; i++) {
				if (tcArr[i] == '(' || tcArr[i] == '{' || tcArr[i] == '[' || tcArr[i] == '<')
					stack.push(tcArr[i]);
				else if (tcArr[i] == ')' || tcArr[i] == '}' || tcArr[i] == ']' || tcArr[i] == '>') {
					char pop = stack.pop();
					if ((tcArr[i] == ')' && pop == '(') || (tcArr[i] == '}' && pop == '{')
							|| (tcArr[i] == ']' && pop == '[') || (tcArr[i] == '>' && pop == '<')) {
						continue;
					} else {
						result = 0;
					}
				}
				if (result == 0)
					break;
			}
			if (stack.size() != 0)
				result = 0;
			else
				result = 1;

			System.out.println("#" + tc + " " + result);

		}
	}
}