import java.util.Stack;

class Solution {
	public static void main(String[] args) {
		System.out.println(solution("({)}"));
	}

	public static int solution(String inputString) {
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		boolean flag = true;
		for (int i = 0; i < inputString.length(); i++) {
			char now = inputString.charAt(i);
			if (now == '(' || now == '{' || now == '[' || now == '<') {
				stack.push(now);
			} else if (now == ')') {
				if (!stack.isEmpty() && stack.peek() == '(') {
					answer++;
					stack.pop();
				} else
					flag = false;
			} else if (now == '}') {
				if (!stack.isEmpty() && stack.peek() == '{') {
					answer++;
					stack.pop();
				} else
					flag = false;
			} else if (now == ']') {
				if (!stack.isEmpty() && stack.peek() == '[') {
					answer++;
					stack.pop();

				} else
					flag = false;
			} else if (now == '>') {
				if (!stack.isEmpty() && stack.peek() == '<') {
					answer++;
					stack.pop();
				} else
					flag = false;
			}
			if (!flag)
				return -1;
		}
		if (stack.size() > 0)
			return -1;

		return answer;
	}
}