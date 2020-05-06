package ETC;

public class Kakao2018_다트게임 {
	public static void main(String[] args) {
		String dartResult = "1D2S#10S";
		System.out.println(solution(dartResult));
	}

	public static int solution(String dartResult) {
		int answer = 0;
		int size = dartResult.length();
		int index = 0;
		int[] score = new int[3];
		for (int i = 0; i < size; i++) {
			char now = dartResult.charAt(i + 1);
			int num = now == '0' ? 10 : now - '0';
			if (now == '0') {
				num = 10;
				i += 2;
			} else {
				num = dartResult.charAt(i) - '0';
				i += 1;
			}

			now = dartResult.charAt(i++);
			switch (now) {
			case 'S':
				break;
			case 'D':
				num = (int) Math.pow(num, 2);
				break;
			case 'T':
				num = (int) Math.pow(num, 3);
				break;
			}
			if (i < size) {
				now = dartResult.charAt(i);
				if (now == '*') {
					score[index] = num * 2;
					if (index > 0)
						score[index - 1] *= 2;
				} else if (now == '#') {
					score[index] = num * -1;
				} else {
					score[index] = num;
					i--;
				}
			} else
				score[index] = num;
			index++;
		}
		return score[0] + score[1] + score[2];
	}
}