package Programmers;

public class Level1_문자열내p와y의개수 {
	public static void main(String[] args) {
		System.out.println(solution("pPoooyY")); // true
		System.out.println(solution("Pyy")); // true
	}

	public static boolean solution(String s) {
		s = s.toLowerCase();
		int p = 0, y = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p')
				p++;
			else if (s.charAt(i) == 'y')
				y++;
		}

		return p == y;
	}
}