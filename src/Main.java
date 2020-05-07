import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {

		System.out.println(solution("FRANCE", "french"));
	}

	public static int solution(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		System.out.println(str1 + " || " + str2);

		List<String> list1 = new LinkedList<>();
		for (int i = 0; i < str1.length() - 1; i++) {
			char c1 = str1.charAt(i);
			char c2 = str1.charAt(i + 1);
			if (check(c1) && check(c2)) {
				list1.add("" + c1 + c2);
			}
		}

		List<String> list2 = new LinkedList<>();
		for (int i = 0; i < str2.length() - 1; i++) {
			char c1 = str2.charAt(i);
			char c2 = str2.charAt(i + 1);
			if (check(c1) && check(c2)) {
				list2.add("" + c1 + c2);
			}
		}

		int A = union(list1, list2);
		int B = intersection(list1, list2);
		System.out.println(A + " " + B);

		if (A == 0)
			return 65536;
		return (int) ((B / (double) A) * 65536);
	}

	private static int intersection(List<String> list1, List<String> list2) {
		List<String> l1 = new LinkedList(list1);
		List<String> l2 = new LinkedList(list2);

		List<String> ans = new LinkedList<>();
		for (String string : l1) {
			if (l2.contains(string)) {
				l2.remove(string);
				ans.add(string);
			}
		}
		return ans.size();
	}

	private static int union(List<String> list1, List<String> list2) {
		List<String> l1 = new LinkedList(list1);
		List<String> l2 = new LinkedList(list2);

		List<String> ans = new LinkedList<>();
		for (String string : l1) {
			if (l2.contains(string)) {
				l2.remove(string);
			}
			ans.add(string);
		}
		ans.addAll(l2);
		return ans.size();
	}

	private static boolean check(char c) {
		if ('A' <= c && c <= 'Z')
			return true;
		return false;
	}
}