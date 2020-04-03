import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		int[][] v = { { 1, 4 }, { 3, 4 }, { 3, 10 } };
		int[] ans = solution(v);
	}

	public static int[] solution(int[][] v) {
		int[] answer = new int[2];
		boolean[] x = new boolean[3];
		boolean[] y = new boolean[3];

		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (v[i][0] == v[j][0]) {
					x[i] = x[j] = true;
				}
				if (v[i][1] == v[j][1]) {
					y[i] = y[j] = true;
				}
			}
		}
		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(y));
		for (int i = 0; i < 3; i++) {
			if(!x[i]) answer[0] = v[i][0];
			if(!y[i]) answer[1] = v[i][1];
		}
		return answer;
	}
}