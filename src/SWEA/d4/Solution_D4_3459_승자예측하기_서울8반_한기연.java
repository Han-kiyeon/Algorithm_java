package com.d4;

import java.io.*;

public class Solution_D4_3459_승자예측하기_서울8반_한기연 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D4_3459_승자예측하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			boolean ans = false; // (ans)? Alice | BOB
			long N = Long.parseLong(br.readLine());
			System.out.println(N);
			int cnt = 1;
			long x = 1;
			while ((x << ++cnt) <= N && N < (x << (cnt + 1))) {
			}

			int index = 0;
			while (true) {
				if (Math.pow(2, index) <= N && N < Math.pow(2, index + 1))
					break;
				index++;
			}
			System.out.println(index);
			System.out.println("cnt = " + cnt + "  " + (1 << cnt));
			// System.out.println((ans) ? "Alice" : "Bob");
		} // end of TC
		br.close();
	}// end of main
}
