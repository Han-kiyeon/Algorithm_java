package com.d3;

import java.util.*;
import java.io.*;

public class Solution_D3_7675_통역사성경이_한기연 {
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/D3_7675_통역사성경이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			long start = System.currentTimeMillis();

			// 시작
			System.out.print("#" + test_case);
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), ".?!");

			// 문장 1개
			for (int i = 0; i < N; i++) {
				String str = st.nextToken();
				//System.out.println(str);
				StringTokenizer st2 = new StringTokenizer(str.trim(), " ");
				int cnt = 0;
				// 단어
				while (st2.hasMoreTokens()) {
					//System.out.println(str);
					str = st2.nextToken();
					if (str.length() == 1) { // 단어가 한글자
						if ('A' <= str.charAt(0) && str.charAt(0) <= 'Z') {// 대문자
							cnt++;
							continue;
							// System.out.println(str);
						}
					} else {
						if (!('A' <= str.charAt(0) && str.charAt(0) <= 'Z')) { // 대문자가 아니면
							continue;
						}
						boolean flag = true;
						for (int s = 1; s < str.length() - 1; s++)
							if (!('a' <= str.charAt(s) && str.charAt(s) <= 'z')) { // 소문자가 아니면
								flag = false;
								break;
							}
						if (flag && 'a' <= str.charAt(str.length() - 1)
								&& str.charAt(str.length() - 1) <= 'z') { // 마지막 글자 소문자.
							cnt++;
							// System.out.println(str);
						}
					}
				}					System.out.print(" " + cnt);

			}
				System.out.println();

			// System.out.println("시간: " + (System.currentTimeMillis() - start) + " ns");
		} // end of test_case
		br.close(); // BufferedReader close
	}// end of main
}