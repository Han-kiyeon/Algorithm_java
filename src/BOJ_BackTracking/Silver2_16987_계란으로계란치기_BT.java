package BOJ_BackTracking;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ_BackTracking
 * @FileName : Silver2_16987_계란으로계란치기_BT.java
 *
 * @Date : 2020. 5. 21.
 * @작성자 : 한기연
 * @메모리 : 16644 kb
 * @실행시간 : 236 ms
 *
 * @Blog : __
 **/
public class Silver2_16987_계란으로계란치기_BT {
	static int N, ans, cnt;
	static int[][] data;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		data = new int[N][2];
		for (int i = 0; i < N; i++) {
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
		}

		ans = 0;
		solve(0);
		System.out.println(ans);
	}

	// x번째 계란으로 다른걸 깰 차례
	private static void solve(int x) {
		if (x == N) {
			if (ans < cnt)
				ans = cnt;
			return;
		}

		// x번째 계란이 깨져있거나 다른 모든 계란이 깨져있으면 넘어감
		if (data[x][0] <= 0 || cnt == N - 1) {
			solve(x + 1);
			return;
		}

		for (int k = 0; k < N; k++) { // k번째 계란을 내려치고 싶다
			if (k == x || data[k][0] <= 0)
				continue;

			data[x][0] -= data[k][1];
			data[k][0] -= data[x][1];
			if (data[x][0] <= 0)
				cnt++;
			if (data[k][0] <= 0)
				cnt++;

			solve(x + 1);

			if (data[x][0] <= 0)
				cnt--;
			if (data[k][0] <= 0)
				cnt--;
			data[x][0] += data[k][1];
			data[k][0] += data[x][1];
		}
	}
}