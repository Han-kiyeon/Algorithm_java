package BOJ.Simulation;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Silver4_11966_요세푸스문제0.java
 *
 * @Date : 2020. 4. 3.
 * @작성자 : 한기연
 * @메모리 : 14444 kb
 * @실행시간 : 116 ms
 *
 * @Blog : __
 **/
public class Silver4_11966_요세푸스문제0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int idx = 0;
		while (list.size() != 0) {
			idx += K - 1;
			while (idx >= list.size())
				idx -= list.size();
			sb.append(list.get(idx));
			list.remove(idx);
			if (list.size() != 0)
				sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}