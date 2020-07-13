package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

	static final int N = 10;

	public static void main(String[] args) {
		Random random = new Random(); // 랜덤함수를 이용

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(100); // 0 ~ 99
		}

		System.out.println("정렬 전: " + Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	private static void selectionSort(int[] arr) {
		int index, temp;
		for (int i = 0; i < arr.length; i++) {
			index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}
}
