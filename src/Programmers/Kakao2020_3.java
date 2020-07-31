package Programmers;

import java.util.*;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Kakao2020_3 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				solution(new String[] { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" })));
		System.out.println(Arrays.toString(		solution(new String[] { "AA", "AB", "AC", "AA", "AC" })));
	}

	private static int[] solution(String[] gems) {
		Set<String> set = new HashSet<>();
		for (String gem : gems) {
			set.add(gem);
		}
		int s = 0;
		int e = 0;
		int size = Integer.MAX_VALUE;
		int len = gems.length;
		int start = 0, end = 0;

		Map<String, Integer> map = new HashMap<>();
		while (e < len && s < len) {
			System.out.println(s + " " + e);
			if (!map.containsKey(gems[e])) {
				map.put(gems[e], 1);
				e++;
			} else {
				map.replace(gems[e], map.get(gems[e]) + 1);
				e++;
			}
			while (map.size() == set.size()) {
				if (size > e - s) {
					System.out.println("!!!" + s + " " + e);
					size = e - s;
					end = e;
					start = s;
				}
				if (map.get(gems[s]) == 1)
					map.remove(gems[s]);
				else {
					map.replace(gems[s], map.get(gems[s]) - 1);
				}
				s++;
			}

		}
		return new int[] { start+1, end };
	}
}
