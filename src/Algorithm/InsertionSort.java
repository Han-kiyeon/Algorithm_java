package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

	static final int N = 10;

	public static void main(String[] args) {
		Random random = new Random(); // 랜덤함수를 이용

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(100); // 0 ~ 99
		}

		System.out.println("정렬 전: " + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
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
