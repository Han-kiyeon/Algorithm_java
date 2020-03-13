package BOJ.DFS_BFS;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DFS_BFS
 * @FileName : Gold5_9663_NQueen.java
 *
 * @Date : 2020. 3. 13.
 * @작성자 : 한기연
 * @메모리 : 14912 kb
 * @실행시간 : 2764 ms
 *
 * @Blog : __
 **/
public class Gold5_9663_NQueen {
	static int N, ans;

	static boolean[] col, slash, backslash;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		col = new boolean[N];
		slash = new boolean[2 * N - 1];
		backslash = new boolean[2 * N - 1];
		
		ans = 0;
		solve(0);
		System.out.println(ans);
	}

	public static void solve(int r) {
		if (r == N) {
			ans++;
			return;
		}
		for (int c = 0; c < N; c++) {
			if (check(r, c)) {
				col[c] = slash[r + c] = backslash[r - c + N - 1] = true;
				solve(r + 1);
				col[c] = slash[r + c] = backslash[r - c + N - 1] = false;
			}
		}
	}
	public static boolean check(int r, int c) {
		if (col[c] || slash[r + c] || backslash[r - c + N - 1])
			return false;
		return true;
	}
}
