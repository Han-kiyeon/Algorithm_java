package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

	static final int N = 10;

	public static void main(String[] args) {
		Random random = new Random(); // 랜덤함수를 이용

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(100); // 0 ~ 99
		}

		System.out.println("정렬 전: " + Arrays.toString(arr));
		mergeSort(0, N - 1, arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	// divide
	private static void mergeSort(int start, int end, int[] arr) {
		if (start >= end)
			return;

		int mid = (start + end) / 2;
		mergeSort(start, mid, arr); // left
		mergeSort(mid + 1, end, arr); // right

		merge(start, mid, end, arr);
	}

	// conquer
	private static void merge(int start, int mid, int end, int[] arr) {
		int[] temp = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;

		// combine
		while (i <= mid && j <= end) {
			if (arr[i] < arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		while (i <= mid)
			temp[k++] = arr[i++];
		while (j <= end)
			temp[k++] = arr[j++];

		// copy
		while (k-- > 0)
			arr[start + k] = temp[k];
	}
}
