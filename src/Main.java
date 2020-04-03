import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			switch (sc.next()) {
			case "push":
				dq.offer(sc.nextInt());
				break;
			case "pop":
				sb.append(dq.size() > 0 ? dq.poll() : -1).append("\n");
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				sb.append(dq.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(dq.size() > 0 ? dq.peek() : -1).append("\n");
				break;
			case "back":
				sb.append(dq.size() > 0 ? dq.peekLast() : -1).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}