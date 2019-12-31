package Programmers;

public class Level1_체육복 {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 })); // 5
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 3 })); // 4
		System.out.println(solution(3, new int[] { 3 }, new int[] { 1 })); // 2
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int[] student = new int[n];
		for (int i = 0; i < lost.length; i++) {
			student[lost[i] - 1]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			student[reserve[i] - 1]++;
		}

		int answer = n;
		for (int i = 0; i < student.length; i++) {
			if (student[i] == -1) {
				if (i - 1 >= 0 && student[i - 1] == 1) {
					student[i]++;
					student[i - 1]--;
				} else if (i + 1 < student.length && student[i + 1] == 1) {
					student[i]++;
					student[i + 1]--;
				} else
					answer--;
			}
		}
		return answer;
	}
}