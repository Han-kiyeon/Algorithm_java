package com.d1;

import java.io.*;
import java.util.*;

public class Solution_D1_2058_자릿수더하기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D1_2058_자릿수더하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int sum = 0;
		for(int i = 0;i<str.length(); i++)
			sum +=str.charAt(i)-'0';
		System.out.println(sum);
		br.close();
	}
}
