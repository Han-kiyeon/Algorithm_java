package BOJ.BF;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold4_1248_맞춰봐.java
 *
 * @Date : 2020. 3. 12.
 * @작성자 : 한기연
 * @메모리 : 15644 kb
 * @실행시간 : 464 ms
 *
 * @Blog : __
 **/

public class Gold4_1248_맞춰봐 {
	static int N;
	static char[][] matrix;
	static int[] data;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		matrix = new char[N][N];
		String str = sc.next();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				matrix[i][j] = str.charAt(idx++);
			}
		}

		data = new int[N];
		flag = false;
		solve(0);
	}

	private static void solve(int depth) {
		if (depth == N) {
			for (int i : data) {
				System.out.print(i + " ");
			}
			System.out.println();
			System.exit(0); // 프로그램 종료
		}
		for (int i = -10; i <= 10; i++) {
			data[depth] = i;
			if (check(depth)) {
				solve(depth + 1);
			}
		}
	}

	private static boolean check(int idx) {
		for (int i = 0; i <= idx; i++) {
			int sum = 0;
			for (int j = i; j <= idx; j++) {
				sum += data[j];
				if (matrix[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) {
					return false;
				}
			}
		}
		return true;
	}
}