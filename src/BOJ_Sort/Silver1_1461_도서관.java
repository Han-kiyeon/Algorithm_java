package BOJ_Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ_Sort
 * @FileName : Silver1_1461_도서관.java
 *
 * @Date : 2020. 5. 17.
 * @작성자 : 한기연
 * @메모리 : 14472 kb
 * @실행시간 : 112 ms
 *
 * @Blog : __
 **/
public class Silver1_1461_도서관 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		LinkedList<Integer> b1 = new LinkedList<>();
		LinkedList<Integer> b2 = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int now = sc.nextInt();
			if (now < 0)
				b1.add(now);
			else
				b2.add(now);
		}
		Collections.sort(b1);
		Collections.sort(b2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int ans = 0;
		int max = 0;
		for (int i = 0; i < b1.size(); i += M) {
			int now = b1.get(i) * -1;
			if (now > max)
				max = now;
			ans += now << 1;
		}
		for (int i = 0; i < b2.size(); i += M) {
			int now = b2.get(i);
			if (now > max)
				max = now;
			ans += now << 1;
		}

		System.out.println(ans - max);

	}
}
