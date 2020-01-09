package SWEA.D3;

import java.util.Scanner;

/**
 * @FileName : Solution_1289_원재의메모리복구하기.java
 * @Project : Algorithm_java
 * @Date : 2019. 7. 15.
 * @작성자 : 한기연
 * @메모리 : 20,540 kb
 * @실행시간 : 138 ms
 **/
public class Solution_1289_원재의메모리복구하기 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int cnt = 0;

		String strRes[] = new String[T];

		for (int tc = 0; tc < T; tc++) {
			String test1 = sc.next();
			char[] tmp = test1.toCharArray();
			char[] res = new char[test1.length()];

			for (int i = 0; i < test1.length(); i++) {
				res[i] = '0';
			}

			for (int i = 0; i < test1.length(); i++) {
				if (res[i] != tmp[i]) {
					char tmpNum = tmp[i];
					for (int j = i; j < test1.length(); j++) {
						res[j] = tmpNum;
					}
					cnt++;
				}
			}
			strRes[tc] = '#' + String.valueOf(tc + 1) + ' ' + String.valueOf(cnt);
			cnt = 0;
		}

		for (int tc = 0; tc < T; tc++) {
			System.out.println(strRes[tc]);
		}
	}
}