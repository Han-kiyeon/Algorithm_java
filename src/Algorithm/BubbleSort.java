package Algorithm;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 4, 5, 7, 3, 9, 0 };
		System.out.println("정렬 전: " + Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		boolean flag = true;
		int n = arr.length;
		while (flag) {
			flag = false;
			for (int i = 0; i < n - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					flag = true;
				}
			}
			n--;
		}
	}
}
