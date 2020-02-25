import java.util.Scanner;

public class Main_백준_17471_게리맨더링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 구역의 개수 N;
		int[] person = new int[N];
		
		for (int i = 0; i < person.length; i++) {
			person[N] = sc.nextInt();
		}

	}
	static void powerSet(int v, int len) {
		if (len >= R) {
			result = (result > len) ? len : result;
			return;
		}
		
		if (v == N)
			return;
		
		powerSet(v + 1, len + data[v]);
		powerSet(v + 1, len);
	}
}
