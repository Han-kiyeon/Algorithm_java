package SWEA.d1;

import java.io.*;
import java.util.*;

public class Solution_D1_2063_중간값찾기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D1_2063_중간값찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		System.out.println(arr[N / 2]);
		br.close();
	}
}
