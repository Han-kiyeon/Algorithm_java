package BOJ.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Gold3_2143_두배열의합.java
 *
 * @Date : 2020. 3. 17.
 * @작성자 : 한기연
 * @메모리 : 48848 kb
 * @실행시간 : 948 ms
 *
 * @Blog : __
 **/
public class Gold3_2143_두배열의합 {
	static int T, N, M;
	static long ans;
	static int[] A, B;

	static List<Integer> a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); // T(-1,000,000,000 ≤ T ≤ 1,000,000,000)

		N = sc.nextInt(); // n(1 ≤ n ≤ 1,000)
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt(); // 절댓값이 1,000,000을 넘지 않는 정수
		}

		M = sc.nextInt();// m(1≤m≤1,000)
		B = new int[M];
		for (int i = 0; i < M; i++) {
			B[i] = sc.nextInt(); // 절댓값이 1,000,000을 넘지 않는 정수
		}

		a = new ArrayList<>();
		get(A, a);
		b = new ArrayList<>();
		get(B, b);

		Collections.sort(b);

		ans = 0;
		for (Integer i : a) {
			int val = T - i;
			int high = upper_bound(b, val);
			int low = lower_bound(b, val);
			ans += high - low;
		}
		System.out.println(ans);
	}

	private static void get(int[] data, List<Integer> list) {
		for (int size = 1; size <= data.length; size++) {
			int sum = 0;
			for (int i = 0; i < size; i++) {
				sum += data[i];
			}
			for (int i = size; i < data.length; i++) {
				list.add(sum);
				sum += data[i];
				sum -= data[i - size];
			}
			list.add(sum);
		}
	}

	// lower bound는 찾고자 하는 값 이상이 처음 나타나는 위치
	private static int lower_bound(List<Integer> list, int val) {
		int start = 0;
		int end = list.size();
		int mid;
		while (start < end) {
			mid = (start + end) >> 1;
			if (list.get(mid) >= val) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	// upper bound는 찾고자 하는 값보다 큰 값이 처음으로 나타나는 위치
	private static int upper_bound(List<Integer> list, int val) {
		int start = 0;
		int end = list.size();
		int mid;
		while (start < end) {
			mid = (start + end) >> 1;
			if (list.get(mid) <= val) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}