package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Level1_K번째수 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 5, 2, 6, 3, 7, 4 },
				new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 }, }))); // [5,6,3]
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				list.add(array[j]);
				
			}
			Collections.sort(list);
			answer[i] = list.get(commands[i][2] - 1);
		}

		return answer;
	}
}