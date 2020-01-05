package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1_같은숫자는싫어 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 1, 3, 3, 0, 1, 1 })));// "1,3,0,1";
		System.out.println(Arrays.toString(solution(new int[] { 4, 4, 4, 3, 3 })));// "4,3";
	}

	public static int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1])
				list.add(arr[i]);
		}

		int[] answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i);

		return answer;
	}
}