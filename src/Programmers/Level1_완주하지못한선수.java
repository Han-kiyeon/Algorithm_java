package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Level1_완주하지못한선수 {
	public static void main(String[] args) {
		System.out.println(
				solution(new String[] { "leo", "kiki", "eden" }, new String[] { "eden", "kiki" }));// leo
		System.out.println(solution(new String[] { "marina", "josipa", "nikola", "vinko", "filipa" },
				new String[] { "josipa", "filipa", "marina", "nikola" }));// vinko
		System.out.println(solution(new String[] { "mislav", "stanko", "mislav", "ana" },
				new String[] { "stanko", "ana", "mislav" }));// mislav
	}

	public static String solution(String[] participant, String[] completion) {
		Map<String, Integer> map = new HashMap<>();
		for (String player : participant)
			map.put(player, map.getOrDefault(player, 0) + 1);
		for (String player : completion)
			map.put(player, map.get(player) - 1);

		String answer = "";
		for (String key : map.keySet()) {
			if (map.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}
}