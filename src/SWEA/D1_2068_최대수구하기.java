package SWEA;

import java.io.*;
import java.util.*;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D1_2068_최대수구하기.java
 *
 * @Date : 2019. 8. 20.
 * @작성자 : 한기연
 * @메모리 : 18,296 kb
 * @실행시간 : 118 ms
 *
 * @Blog : __
 **/
public class D1_2068_최대수구하기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D1_2068_최대수구하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				max = (max > tmp) ? max : tmp;
			}
			System.out.println("#" + tc + " " + max);
		}
		br.close();
	}
}
