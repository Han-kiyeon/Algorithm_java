import java.util.Scanner;

public class Main {
	static int data, rlt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			data = sc.nextInt();
			rlt = 0;
			DFS(0);
			System.out.println(rlt);
		}
	}

	private static void DFS(int x) {
		if (x == data) {
			rlt++;
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if ((x + i) <= data)
				DFS(x + i);
		}
	}
}