package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {

	static final int N = 10;

	public static void main(String[] args) {
		Random random = new Random(); // 랜덤함수를 이용

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(100); // 0 ~ 99
		}

		System.out.println("정렬 전: " + Arrays.toString(arr));
		radixSort(arr);
		System.out.println("정렬 후: " + Arrays.toString(arr));
	}

	private static void radixSort(int[] arr) {
		// 최대값 구하기
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}

		// Counting Sort를 사용하여 해당 자리 정렬하기.
		for (int digit = 1; digit <= max; digit *= 10) {
			countingSort(arr, digit);
		}
	}

	private static void countingSort(int[] arr, int digit) {
		int[] temp = new int[N]; // 임시로 사용할 공간
		int[] counting = new int[10]; // 카운팅 배열

		for (int i = 0; i < N; i++) {
			int num = (arr[i] / digit) % 10; // 해당 자리수의 숫자 추출
			counting[num]++;
		}

		// 누적합 배열로 만들기
		for (int i = 1; i < counting.length; i++) {
			counting[i] += counting[i - 1];
		}

		// 뒤에서 부터 시작 >> 값이 큰것이 뒤로 가야하기 때문
		for (int i = 0; i < N; i++) {
			int num = (arr[i] / digit) % 10;
			int index = counting[num];

			temp[index - 1] = arr[i];
			counting[num]--;
		}

		// 복사
		for (int i = 0; i < N; i++) {
			arr[i] = temp[i];
		}
	}

}
