package SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_5일차_D3_1221_GNS.java
 *
 * @Date : 2019. 8. 3.
 * @작성자 : 한기연
 * @메모리 : 79,152 kb
 * @실행시간 : 406 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_5일차_D3_1221_GNS {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1221_D3_GNS.txt"));
		Scanner s = new Scanner(System.in);

		int T = s.nextInt(); // TC의 개수

		// System.out.println(T);

		for (int tc = 1; tc <= T; tc++) {
			System.out.println(s.next()); // 테스트 케이스 번호
			int N = s.nextInt(); // 테스트 케이스의 길이
			// System.out.println(N);
			int[] cntArr = new int[10];
			for (int i = 0; i < N; i++) {
				switch (s.next()) {
				case "ZRO":	cntArr[0]++; break;
				case "ONE":	cntArr[1]++; break;
				case "TWO":	cntArr[2]++; break;
				case "THR":	cntArr[3]++; break;
				case "FOR":	cntArr[4]++; break;
				case "FIV":	cntArr[5]++; break;
				case "SIX":	cntArr[6]++; break;
				case "SVN":	cntArr[7]++; break;
				case "EGT":	cntArr[8]++; break;
				case "NIN":	cntArr[9]++; break;
				}
			}
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < cntArr[i]; j++) {
					switch (i) {
					case 0: System.out.print("ZRO "); break;
					case 1: System.out.print("ONE "); break;
					case 2: System.out.print("TWO "); break;
					case 3: System.out.print("THR "); break;
					case 4: System.out.print("FOR "); break;
					case 5: System.out.print("FIV "); break;
					case 6: System.out.print("SIX "); break;
					case 7: System.out.print("SVN "); break;
					case 8: System.out.print("EGT "); break;
					case 9: System.out.print("NIN "); break;
					}
				}
			System.out.println();
		}

		s.close();

	}

}