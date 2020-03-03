package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D1_2071_평균값구하기.java
 *
 * @Date : 2019. 8. 20.
 * @작성자 : 한기연
 * @메모리 : 18,288 kb
 * @실행시간 : 115 ms
 *
 * @Blog : __
 **/
public class D1_2071_평균값구하기 {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/D1_2071_평균값구하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int avg = 0;
			String[] nums = br.readLine().split(" ");

			for (String num : nums)
				avg += Integer.parseInt(num);

			// System.out.println(avg);

			if (avg % 10 >= 5)
				avg = avg / 10 + 1;
			else
				avg = avg / 10;

			System.out.println("#" + tc + " " + avg);
		}

		br.close();
	}
}
