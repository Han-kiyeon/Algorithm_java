package BOJ_ETC;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ_ETC
 * @FileName : Silver4_9012_괄호.java
 *
 * @Date : 2020. 4. 2.
 * @작성자 : 한기연
 * @메모리 : 14700 kb
 * @실행시간 : 124 ms
 *
 * @Blog : __
 **/
public class Silver4_9012_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < N; tc++) {
			Stack<Character> stack = new Stack<>();

			String input = sc.next();
			boolean flag = true;
			for (int i = 0; i < input.length(); i++) {
				char now = input.charAt(i);
				if (now == '(')
					stack.push(now);
				else if (now == ')') {
					if (stack.size() > 0)
						stack.pop();
					else
						flag = false;
				}
				if (!flag)
					break;
			}
			if (stack.size() > 0)
				flag = false;
			sb.append(flag ? "YES\n" : "NO\n");
		} // end of TC
		System.out.println(sb);
	}
}