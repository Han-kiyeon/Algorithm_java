package Programmers;

import java.util.*;

public class Level1_문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(new String[] { "sun", "bed", "car" }, 1)));
		System.out.println(Arrays.deepToString(solution(new String[] { "abce", "abcd", "cdx" }, 2)));

	}

	public static String[] solution(String[] strings, int n) {
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.charAt(n) == o2.charAt(n))
					return o1.compareTo(o2);
				return o1.charAt(n) - o2.charAt(n);
			}
		});
		return strings;
	}
}