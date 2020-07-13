package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	static final int N = 10;

	public static void main(String[] args) {
		Random random = new Random(); // 랜덤함수를 이용

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(100); // 0 ~ 99
		}

		System.out.println("정렬 전: " + Arrays.toString(arr));
		quickSort(0, N - 1, arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	private static void quickSort(int start, int end, int[] arr) {
		if (start >= end)
			return;

		int left = start + 1, right = end, temp;
		int pivot = arr[start];

		while (left <= right) {
			while (left <= end && arr[left] <= pivot)
				left++;
			while (right > start && arr[right] >= pivot)
				right--;
			if (left <= right) {
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			} else {
				temp = arr[right];
				arr[right] = arr[start];
				arr[start] = temp;
			}
		}
		quickSort(start, right - 1, arr);
		quickSort(right + 1, end, arr);
	}
}
