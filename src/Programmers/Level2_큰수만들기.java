package Programmers;

class Level2_큰수만들기 {
	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
		System.out.println(solution("1000", 2));
	}

	public static String solution(String number, int k) {
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		int len = number.length() - k; // 반환해야 하는 문자열의 길이
		while (len > 0) {
			int max = -1;
			for (int i = idx; i <= number.length() - len; i++) {
				int num = number.charAt(i) - '0';
				if (max < num) {
					max = num;
					idx = i;
				}
			}
			len--;
			sb.append(number.charAt(idx++));
		}
		return sb.toString();
	}
}