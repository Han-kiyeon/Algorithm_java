package com.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_3459_승자예측하기_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			long n = Long.parseLong(br.readLine());
			int index = 0;
			while (true) {
				if (Math.pow(2, index) <= n && n < Math.pow(2, index + 1))
					break;
				index++;
			}
			long sum = 1;
			String str = "";
			if (index % 2 == 1) { // 홀수면 엘리스가 할 차례
				for (int i = 1; i <= index; i++) {
					if (i % 2 == 1)
						sum = sum * 2; // 홀수면 엘리스
					else
						sum = sum * 2 + 1; // 밥이니까 최대를 골라서 죽이려할거_
				}
				if (n < sum)
					str = "Bob";
				else
					str = "Alice";
			} else { // 짝수여서 밥이 마지막인 경우이므로
				for (int i = 1; i <= index; i++) {
					if (i % 2 == 1)
						sum = sum * 2 + 1; // 엘리스는 죽이려할꺼
					else
						sum = sum * 2; // 안죽고싶어
				}
				if (n < sum)
					str = "Alice";
				else
					str = "Bob";
			}
			System.out.println("#" + t + " " + str);
		}
	}
}