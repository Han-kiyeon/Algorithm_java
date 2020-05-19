import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] route0 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 };
	static int[] route1 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35,
			40 };
	static int[] route2 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40 };
	static int[] route3 = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40 };

	static int[] cmd;
	static int[] move;
	static int[][] horse;

	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		cmd = new int[10];
		for (int i = 0; i < 10; i++) { // 입력되는 명령어의 수 10개
			cmd[i] = sc.nextInt();
		}
		sc.close();
		// 입력 끝

		move = new int[10];
		max = Integer.MIN_VALUE;
		DFS(0);
		// int[] tmp = { 0, 0, 1, 1, 0, 0, 0, 0, 1, 1 };
		// move = tmp.clone();
		// System.out.println(solve());
		System.out.println(max);
	}

	private static void DFS(int depth) {
		if (depth == cmd.length) {
			int sum = solve();
			if (max < sum) {
				max = sum;
				// System.out.println(sum);
				// System.out.println(Arrays.toString(move));
				// for (int[] is : horse) {
				// System.out.println(Arrays.toString(is));
				// }
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			move[depth] = i;
			DFS(depth + 1);
		}

	}

	private static int solve() {
		horse = new int[4][2]; // 말의 위치, 가는 길, 움직인 횟수
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			int cur = move[i]; // 현재움직일 말의 번호.
			horse[cur][0] += cmd[i]; // 움직였을때의 위치.
			int tmp = horse[cur][1];
			// System.out.println("i=" + i + ", cur=" + cur + ", cmd[i]=" + cmd[i]);
			// System.out.println("현재 말: " + cur);
			// System.out.println("움직인 위치: " + horse[cur][0]);
			// System.out.println("가고있는길" + horse[cur][1]);

			// ================길 변경================
			if (horse[cur][1] == 0) {
				if (horse[cur][0] == 5)
					horse[cur][1] = 3;
				else if (horse[cur][0] == 10)
					horse[cur][1] = 2;
				else if (horse[cur][0] == 15)
					horse[cur][1] = 1;

				// System.out.println("change" + horse[cur][1]);
			}

			// ================중복체크================
			// 이동하려고 하는 칸에 말이 이미 있는 경우에는 그 칸으로 이동할 수 없다.
			// --------------1--2--3--4---5---6---7---8---9--10--11--12--13--14--15--16--17--18--19--20--21--22
			// route0 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 };
			// route1 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40 };
			// route2 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40 };
			// route3 = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40 };
			boolean flag = false;
			int j = 0;
			for (; j < horse.length; j++) {
				if (cur != j) {
					if (horse[cur][0] == horse[j][0] && horse[cur][1] == horse[j][1]) {
						flag = true;
						break;
					} else if ((horse[cur][1] == 1 && horse[cur][0] == 19)
							|| (horse[cur][1] == 2 && horse[cur][0] == 13)
							|| (horse[cur][1] == 3 && horse[cur][0] == 9)) {
						// 25번에 도착했을때
						if (horse[j][1] == 1 && horse[j][0] == 19) {// 1번길에 같은위치
							flag = true;
							break;
						} else if (horse[j][1] == 2 && horse[j][0] == 13) {// 2번길에 같은위치
							flag = true;
							break;
						} else if (horse[j][1] == 3 && horse[j][0] == 9) {// 3번길에 같은위치
							flag = true;
							break;
						}
					} else if ((horse[cur][1] == 1 && horse[cur][0] == 20)
							|| (horse[cur][1] == 2 && horse[cur][0] == 14)
							|| (horse[cur][1] == 3 && horse[cur][0] == 10)) {
						// 30번에 도착했을때
						if (horse[j][1] == 1 && horse[j][0] == 20) {// 1번길에 같은위치
							flag = true;
							break;
						} else if (horse[j][1] == 2 && horse[j][0] == 14) {// 2번길에 같은위치
							flag = true;
							break;
						} else if (horse[j][1] == 3 && horse[j][0] == 10) {// 3번길에 같은위치
							flag = true;
							break;
						}
					}

					else if ((horse[cur][1] == 1 && horse[cur][0] == 21)
							|| (horse[cur][1] == 2 && horse[cur][0] == 15)
							|| (horse[cur][1] == 3 && horse[cur][0] == 11)) {
						// 35번에 도착했을때
						if (horse[j][1] == 1 && horse[j][0] == 21) {// 1번길에 같은위치
							flag = true;
							break;
						} else if (horse[j][1] == 2 && horse[j][0] == 15) {// 2번길에 같은위치
							flag = true;
							break;
						} else if (horse[j][1] == 3 && horse[j][0] == 11) {// 3번길에 같은위치
							flag = true;
							break;
						}
					} else if ((horse[cur][1] == 0 && horse[cur][0] == 20)
							|| (horse[cur][1] == 1 && horse[cur][0] == 22)
							|| (horse[cur][1] == 2 && horse[cur][0] == 16)
							|| (horse[cur][1] == 3 && horse[cur][0] == 12)) {
						// 40번에 도착했을때
						if (horse[j][1] == 0 && horse[j][0] == 20) {// 0번길에 같은위치
							flag = true;
							break;
						} else if (horse[j][1] == 1 && horse[j][0] == 22) {// 1번길에 같은위치
							flag = true;
							break;
						} else if (horse[j][1] == 2 && horse[j][0] == 16) {// 2번길에 같은위치
							flag = true;
							break;
						} else if (horse[j][1] == 3 && horse[j][0] == 12) {// 3번길에 같은위치
							flag = true;
							break;
						}
					}
				}
			}
			if (flag) {
				return Integer.MIN_VALUE;
			}

			// ================더하기================
			if (horse[cur][1] == 0 && horse[cur][0] < route0.length)
				sum += route0[horse[cur][0]];
			else if (horse[cur][1] == 1 && horse[cur][0] < route1.length)
				sum += route1[horse[cur][0]];
			else if (horse[cur][1] == 2 && horse[cur][0] < route2.length)
				sum += route2[horse[cur][0]];
			else if (horse[cur][1] == 3 && horse[cur][0] < route3.length)
				sum += route3[horse[cur][0]];

			// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sum);

		}

		return sum;
	}

}