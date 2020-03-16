package BOJ.BF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Gold2_1208_부분수열의합2.java
 *
 * @Date : 2020. 3. 16.
 * @작성자 : 한기연
 * @메모리 : 83140 kb
 * @실행시간 : 1360 ms
 *
 * @Blog : __
 **/

public class Gold2_1208_부분수열의합2 {
	static int N, S;
	static int ans; // int :2^32 long: 2^64 >> 문제: 2^40
	static int[] input;
	static ArrayList<Integer> L, R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		L = new ArrayList<>();
		R = new ArrayList<>();
		solve(0, N / 2, 0, L);
		solve(N / 2, N, 0, R);

		Collections.sort(R);

		ans = 0;
		for (int val : L) {
			val = S - val;
			int hi = upper_bound(R, val);
			int lo = lower_bound(R, val);
			ans += hi - lo;
		}

		// 공집합 제거
		if (S == 0) {
			--ans;
		}
		System.out.println(ans);
	}

	// lower bound는 찾고자 하는 값 이상이 처음 나타나는 위치
	private static int lower_bound(ArrayList<Integer> list, int val) {
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
	private static int upper_bound(ArrayList<Integer> list, int val) {
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

	// 범위에 해당하는 모든 부분수열의 합을 저장.
	private static void solve(int pos, int end, int sum, ArrayList<Integer> list) {
		if (pos == end) {
			list.add(sum);
			return;
		}
		solve(pos + 1, end, sum, list);
		solve(pos + 1, end, sum + input[pos], list);
	}

}