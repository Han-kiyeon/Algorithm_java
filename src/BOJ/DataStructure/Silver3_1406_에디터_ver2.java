package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.DataStructure
 * @FileName : Silver3_1406_에디터_ver2.java
 *
 * @Date : 2020. 6. 28.
 * @작성자 : 한기연
 * @메모리 : 119188 kb
 * @실행시간 : 804 ms
 *
 * @Blog : __
 **/
public class Silver3_1406_에디터_ver2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			left.add(str.charAt(i));
		}

		int M = Integer.parseInt(br.readLine());

		for (int k = 0; k < M; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
				case "L":
					if (!left.isEmpty())
						right.push(left.pop());
					break;
				case "D":
					if (!right.isEmpty())
						left.push(right.pop());
					break;
				case "B":
					if (!left.isEmpty())
						left.pop();
					break;
				case "P":
					left.push(st.nextToken().charAt(0));
					break;
			}
		}

		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		while (!right.isEmpty()) {
			bw.write(right.pop());
		}

		bw.flush();
	}
}