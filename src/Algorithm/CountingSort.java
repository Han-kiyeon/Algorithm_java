package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	static final int N = 10;

	public static void main(String[] args) {
		Random random = new Random(); // 랜덤함수를 이용

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(100); // 0 ~ 99
		}

		System.out.println("정렬 전: " + Arrays.toString(arr));
		countingSort(arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	private static void countingSort(int[] arr) {
		// 최대값 구하기
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}

		int[] counting = new int[max + 1]; // 카운팅 배열

		for (int i = 0; i < N; i++) {
			counting[arr[i]]++;
		}

		int index = 0;
		for (int i = 0; i < counting.length; i++) {
			while (counting[i]-- > 0) {
				arr[index++] = i;
			}
		}
	}
}
