import java.util.Arrays;

// 순열
public class Test {

	static int[] numbers = { 1, 2, 3, 4 };
	static int N = 4;

	public static void main(String[] args) {
		Arrays.sort(numbers); // 오름차순
		do {
			System.out.println(Arrays.toString(numbers));
		} while (np());
	}

	private static boolean np() {
		// 1. 교환 필요한 위치(i-1) 찾기
		int i = N - 1;

		// 나보다 작은 값 찾는중
		while (i > 0 && numbers[i - 1] >= numbers[i]) {
			--i; // 비교할 자리 한 칸 앞으로 당기기
		}

		if (i == 0) { // 제일 큰 순열이라는 뜻
			return false;
		}

		// 2. i-1 위치값과 교환할 j값 찾기(i-1 위치 뒤쪽에서!)
		// i-1 위치값보다 크면서 이 자리에 올 수 있는 i-1 위치 뒤쪽에서의 가장 작은 값
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) {
			--j; // 앞으로 한 칸 이동
		}

		// 3. i-1 위치값과 j위치값 교환
		int temp = numbers[i - 1];
		numbers[i - 1] = numbers[j];
		numbers[j] = temp;

		// 4. i-1 위치 뒤쪽으로 가장 작은 순열로 정렬
		j = N - 1;
		while (i < j) {
			temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
			++i;
			--j;
		}
		return true;
	}
}