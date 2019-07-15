package SWEA;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.reflect.Array;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D3_1289_원재의메모리복구하기.java
 *
 * @Date : 2020. 7. 15.
 * @작성자 : 한기연
 * @메모리 : 20,540 kb
 * @실행시간 : 138 ms
 *
 * @Blog : __
 **/
public class D3_1289_원재의메모리복구하기 {
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