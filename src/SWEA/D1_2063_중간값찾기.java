package SWEA;

import java.io.*;
import java.util.*;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D1_2063_중간값찾기.java
 *
 * @Date : 2019. 7. 15.
 * @작성자 : 한기연
 * @메모리 : 20,780 kb
 * @실행시간 : 153 ms
 *
 * @Blog : __
 **/
public class D1_2063_중간값찾기 {

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
