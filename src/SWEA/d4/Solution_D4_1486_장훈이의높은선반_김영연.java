package com.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_1486_장훈이의높은선반_김영연 {
	static int[] result;
	static int[] height;
	static int count, min, top;

	public static void comb(int index, int start) {
		if (index == count) {
			int sum = 0;
			for (int i = 0; i < count; i++)
				sum += result[i];
			if (sum >= top && sum - top < min)
				min = sum - top;
			return;
		}
		for (int i = start; i < height.length; i++) {
			result[index] = height[i];
			comb(index + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D4_1486_장훈이의높은선반.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			top = Integer.parseInt(input[1]);
			min = Integer.MAX_VALUE;
			height = new int[N];
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < str.length; i++)
				height[i] = Integer.parseInt(str[i]);
			for (count = 1; count <= N; count++) {
				result = new int[count];
				comb(0, 0);
			}
			System.out.println("#" + tc + " " + min);
		}
	}
}