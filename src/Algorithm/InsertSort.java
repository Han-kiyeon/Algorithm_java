package Algorithm;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = { 4, 5, 7, 3, 9, 0 };
		System.out.println("정렬 전: " + Arrays.toString(arr));
		insertSort(arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	private static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
}
