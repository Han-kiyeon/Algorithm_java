package Codility;

import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));
		System.out.println(solution(new int[] { 1, 1, 3 }));
	}

	private static int solution(int[] A) {
		Arrays.sort(A);
		for (int i = 0; i < A.length - 1; i += 2) {
			if (A[i] != A[i + 1])
				return A[i];
		}
		return A[A.length - 1];
	}

}
