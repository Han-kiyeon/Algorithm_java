package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D3_3499_퍼팩트셔플.java
 *
 * @Date : 2019. 8. 6.
 * @작성자 : 한기연
 * @메모리 : 37,732 kb
 * @실행시간 : 198 ms
 *
 * @Blog : __
 **/
public class D3_3499_퍼팩트셔플 {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/3499_D3_퍼펙트셔플.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 덱의 카드 수

			String[] cards = new String[N];
			String[] shuffle = new String[N];

			for (int i = 0; i < N; i++)
				cards[i] = sc.next();
			int cnt = 0;
			if (N % 2 == 0) {
				for (int i = 0; i < N / 2; i++) {
					shuffle[cnt] = cards[i];
					cnt += 2;
				}
				cnt = 1;
				for (int i = N / 2; i < N; i++) {
					shuffle[cnt] = cards[i];
					cnt += 2;
				}
			} else {
				for (int i = 0; i <= N / 2; i++) {
					shuffle[cnt] = cards[i];
					cnt += 2;
				}
				cnt = 1;
				for (int i = N / 2 + 1; i < N; i++) {
					shuffle[cnt] = cards[i];
					cnt += 2;
				}
			}

			System.out.print("#" + tc + " ");
			for (String s : shuffle)
				System.out.print(s + " ");
			System.out.println();
		}
		sc.close();
	}
}