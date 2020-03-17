package BOJ.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Math
 * @FileName : Gold2_7453_합이0인네정수.java
 *
 * @Date : 2020. 3. 17.
 * @작성자 : 한기연
 * @메모리 : 140708 kb
 * @실행시간 : 2552 ms
 *
 * @Blog : __
 **/
public class Gold2_7453_합이0인네정수 {
	static int N;
	static int[][] data;
	static int[] AB, CD;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		data = new int[4][N];
		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		AB = new int[N * N];
		CD = new int[N * N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[i * N + j] = data[0][i] + data[1][j];
				CD[i * N + j] = data[2][i] + data[3][j];
			}
		}

		Arrays.sort(CD);

		for (int i : AB) {
			int high = upper_bound(CD, -i);
			int low = lower_bound(CD, -i);
			ans += high - low;
		}

		System.out.println(ans);
	}

	// lower bound는 찾고자 하는 값 이상이 처음 나타나는 위치
	private static int lower_bound(int[] arr, int val) {
		int start = 0;
		int end = arr.length;
		int mid;
		while (start < end) {
			mid = (start + end) >> 1;
			if (arr[mid] >= val) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	// upper bound는 찾고자 하는 값보다 큰 값이 처음으로 나타나는 위치
	private static int upper_bound(int[] arr, int val) {
		int start = 0;
		int end = arr.length;
		int mid;
		while (start < end) {
			mid = (start + end) >> 1;
			if (arr[mid] <= val) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}