package Algorithm;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 7, 2, 10, 1, 6, 9, 4, 5, 8, 3 };
		System.out.println("정렬 전: " + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	// arr[start] ~ arr[end]를 정렬한다.
	private static void quickSort(int[] arr, int start, int end) {
		if (end - start <= 0) 
			return; 
		
		int pivot = arr[end];
		int left = start;
		int right = end - 1;
		
		while (true) {
			while (left <= right && arr[left] <= pivot)
				left++;
			while (left <= right && arr[right] >= pivot)
				right--;
			
			if (left > right)
				break;
			
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
		}
		int tmp = arr[end];
		arr[end] = arr[left];
		arr[left] = tmp;

		quickSort(arr, start, left - 1);
		quickSort(arr, left + 1, end);
	}

}
