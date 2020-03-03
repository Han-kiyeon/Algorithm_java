package SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_3일차_D3_1213_String.java
 *
 * @Date : 2019. 7. 22.
 * @작성자 : 한기연
 * @메모리 : 27,176 kb
 * @실행시간 : 163 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_3일차_D3_1213_String {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1213_D3_String.txt"));
		Scanner s = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			s.nextInt(); // tc 입력
			String seach = s.next(); // 검색할 단어
			String senten = s.next(); // 문장

			int ans = 0;

			for (int i = 0; i < senten.length();) {
				int find = senten.indexOf(seach, i); // 문자열에서 검색하는 문자의 위치를 반환
				if (find != -1) {// 없을때 -1반환
					ans++;
					i = find + 1; // 다음 위치부터 시작
				} else
					break;
			}

			System.out.println("#" + tc + " " + ans);

		}
		s.close();
	}

}