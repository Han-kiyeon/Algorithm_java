package ETC;
import java.util.LinkedList;
import java.util.Queue;

public class kakao2018_캐시 {

	public static void main(String[] args) {
		System.out.println(solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo",
				"Seoul", "NewYork", "LA" })); // 50
		System.out.println(solution(3,
				new String[] { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" })); // 21
		System.out.println(solution(2, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco",
				"Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" })); // 60
		System.out.println(solution(5, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco",
				"Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" })); // 52
		System.out.println(solution(2, new String[] { "Jeju", "Pangyo", "NewYork", "newyork" })); // 16
		System.out.println(solution(0, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" })); // 25
	}

	public static int solution(final int cacheSize, String[] cities) {
		int answer = 0;

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		Queue<String> queue = new LinkedList<>();

		for (String string : cities) {
			// System.out.println(string);
			if (queue.contains(string.toUpperCase())) {
				answer++;
				queue.remove(string.toUpperCase());
				queue.add(string.toUpperCase());
			} else {
				queue.add(string.toUpperCase());
				answer += 5;
				if (queue.size() > cacheSize) {
					queue.poll();
				}
			}
		}

		return answer;
	}
}
