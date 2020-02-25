package com.d1;

import java.io.*;
import java.util.*;

public class Solution_D1_2072_홀수만더하기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D1_2071_평균값구하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int avg = 0;
			String[] nums = br.readLine().split(" ");

			for (String num : nums)
				avg += Integer.parseInt(num);

			//System.out.println(avg);

//			if (avg % 10 >= 5)
//				avg = avg / 10 + 1;
//			else
//				avg = avg / 10;
			//Math.round(avg/10)
			
			avg = (int) Math.round(avg/10.0);

			System.out.println("#" + tc + " " + avg);
		}

		br.close();
	}
}
