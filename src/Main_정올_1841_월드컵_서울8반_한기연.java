import java.util.Scanner;

public class Main_정올_1841_월드컵_서울8반_한기연 {

	static int[] team1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] team2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
	static int[][] matrix;
	static int[][] result;
	static int[] ans;

	static void dfs(int tc, int game) {
		if (game == 15) { // 모든 경기를 마치고
			if (ans[tc] != 1) { // 이전에 판별되지 않았다면
				// 판별시작
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 3; j++)
						// 결과가 하나라도 같지 않다면
						if (matrix[i][j] != result[i][j])
							return;
				}

				// 경기결과가 일치한다면
				ans[tc] = 1; // 결과테이블에 저장
				return;

			} else
				return;
		}

		// ---------------------DFS--------------------- //
		// |승0|무1|패2|

		int t1 = team1[game];
		int t2 = team2[game];
		// t1 win, t2 lose
		result[t1][0]++;
		result[t2][2]++;
		dfs(tc, game + 1);
		result[t1][0]--;
		result[t2][2]--;
		// t1 draw, t2 draw
		result[t1][1]++;
		result[t2][1]++;
		dfs(tc, game + 1);
		result[t1][1]--;
		result[t2][1]--;
		// t1 lose, t2 win
		result[t1][2]++;
		result[t2][0]++;
		dfs(tc, game + 1);
		result[t1][2]--;
		result[t2][0]--;

	}

	public static void main(String[] args) {
		// 백준_6987_월드컵
		// 정올_1841_월드컵
		Scanner sc = new Scanner(System.in);

		matrix = new int[6][3];
		result = new int[6][3];
		ans = new int[4];

		for (int tc = 0; tc < 4; tc++) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			dfs(tc, 0);
		}

		for (int x : ans)
			System.out.print(x + " ");
		System.out.println();

		sc.close();
	}
}
