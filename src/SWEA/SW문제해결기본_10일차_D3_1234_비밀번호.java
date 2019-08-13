package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_10일차_D3_1234_비밀번호.java
 *
 * @Date : 2019. 8. 13.
 * @작성자 : 한기연
 * @메모리 : 19,236 kb
 * @실행시간 : 126 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_10일차_D3_1234_비밀번호 {

	private static LinkedList<Integer> data;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/1234_D3_비밀번호.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			data = new LinkedList<>();
			String str = st.nextToken();
			for (int i = 0; i < N; i++)
				data.add(str.charAt(i) - '0');
			// System.out.println(data);

			while (true) {
				boolean flag = true;
				for (int i = 0; i < data.size() - 1; i++) {
					if (data.get(i) == data.get(i + 1)) {
						data.remove(i);
						data.remove(i);
						i--;
						flag = false;
					}
				}
				if (flag)
					break;
			}
			System.out.print("#" + tc + " ");
			for (int x : data)
				System.out.print(x);
			System.out.println();
		}

		br.close();
		bw.close();
	}
}