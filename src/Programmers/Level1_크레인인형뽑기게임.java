package Programmers;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Project : Algorithm_java
 * @PackageName: Programmers
 * @FileName : Level1_크레인인형뽑기게임.java
 *
 * @Date : 2020. 5. 11.
 * @작성자 : 한기연
 **/
public class Level1_크레인인형뽑기게임 {
	public static void main(String[] args) {
		System.out.println(solution(
				new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 },
						{ 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } },
				new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
	}

	public static int solution(int[][] board, int[] moves) {
		int N = board.length;

		LinkedList<Integer>[] list = new LinkedList[N];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<>();
		}
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (board[i][j] != 0)
					list[j].add(board[i][j]);
			}
		}

		Stack<Integer> st = new Stack<>();
		int answer = 0;
		for (int m : moves) {
			if (list[m - 1].size() == 0)
				continue;

			int now = list[m - 1].pollFirst();
			if (!st.isEmpty() && st.peek() == now) {
				st.pop();
				answer += 2;
			} else
				st.push(now);
		}
		return answer;
	}
}