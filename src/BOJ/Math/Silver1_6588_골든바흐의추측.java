package BOJ.Math;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Silver1_6588_골든바흐의추측.java
 *
 * @Date : 2020. 1. 24.
 * @작성자 : 한기연
 * @메모리 : 75052 kb
 * @실행시간 : 1076 ms
 **/

public class Silver1_6588_골든바흐의추측 {
	static boolean[] primeNums = new boolean[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		eratosthenes();
		while (true) {
			int N = sc.nextInt();
			if (N == 0)
				break;
			boolean flag = false;
			for (int i = 0, j = N; i <= (N >> 1); i++, j--) {
				if (i % 2 == 1 && j % 2 == 1 && !primeNums[i] && !primeNums[j]) {
					System.out.println(N + " = " + i + " + " + j);
					flag = true;
					break;
				}
			}
			if (!flag)
				System.out.println("Goldbach's conjecture is wrong.");
		}
		sc.close();
	}

	private static void eratosthenes() {
		primeNums[1] = true; // 1은 소수가 아니다.
		for (int i = 2; i <= 1000000; i++)
			if (!primeNums[i]) // i가 소수라면
				for (int j = 2; i * j <= 1000000; j++)
					primeNums[i * j] = true; // 소수 i의 배수는 소수가 아니다.

	}
}
