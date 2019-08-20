package SWEA;
import java.io.*;
import java.util.*;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D1_2070_큰놈작은놈같은놈.java
 *
 * @Date : 2019. 8. 20.
 * @작성자 : 한기연
 * @메모리 : 17,232 kb
 * @실행시간 : 115 ms
 *
 * @Blog : __
 **/
public class D1_2070_큰놈작은놈같은놈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D1_2070_큰놈작은놈같은놈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == b)
				System.out.println("#" + tc + " " + "=");
			else if (a > b)
				System.out.println("#" + tc + " " + ">");
			else
				System.out.println("#" + tc + " " + "<");
		}

		br.close();
	}
}
