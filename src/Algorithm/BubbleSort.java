package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
	static final int N = 10;

	public static void main(String[] args) {
		Random random = new Random(); // 랜덤함수를 이용

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(100); // 0 ~ 99
		}

		System.out.println("정렬 전: " + Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		boolean flag = true;
		int temp;
		for (int n = arr.length - 1; n > 0 && flag; n--) {
			flag = false;
			for (int i = 0; i < n; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					flag = true;
				}
			}
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
