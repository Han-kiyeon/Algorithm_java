package SWEA;

import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D4_5432_쇠막대기자르기.java
 *
 * @Date : 2019. 7. 30.
 * @작성자 : 한기연
 * @메모리 : 38,580 kb
 * @실행시간 : 216 ms
 *
 * @Blog : __
 **/
public class D4_5432_쇠막대기자르기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("res/input_D4_5432_쇠막대기자르기.txt"));
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int cnt = 0;
			int tot = 0;

			// Stack<Charcter> stack = new Stack<>();
			// boolean isOpen = false;

			char[] arr = s.next().toCharArray();
			// System.out.println(Arrays.toString(arr));

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(') {
					cnt++;
					// stack.push(arr[i]);
					// isOpen = true;
				} else {
					cnt--;
					// stack.pop()
					if (arr[i - 1] == '(')
						// if(isOpen)
						tot += cnt;
					// tot += stack.size();
					else
						tot++;
					// isOpen = false;
				}

			}
			System.out.println("#" + tc + " " + tot);
		}
		s.close();

	}

}