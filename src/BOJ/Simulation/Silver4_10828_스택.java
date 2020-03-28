package BOJ.Simulation;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Silver4_10828_스택.java
 *
 * @Date : 2020. 4. 2.
 * @작성자 : 한기연
 * @메모리 : 25984 kb
 * @실행시간 : 264 ms
 *
 * @Blog : __
 **/
public class Silver4_10828_스택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			switch (sc.next()) {
			case "push":
				stack.push(sc.nextInt());
				break;
			case "pop":
				sb.append(stack.size() == 0 ? -1 : stack.pop()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append(stack.size() == 0 ? 1 : 0).append("\n");
				break;
			case "top":
				sb.append(stack.size() == 0 ? -1 : stack.peek()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}