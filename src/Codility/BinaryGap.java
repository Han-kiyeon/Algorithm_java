package Codility;
import java.util.ArrayList;

class BinaryGap {
	public static void main(String[] args) {
		System.out.println(solution(9)); // 2
		System.out.println(solution(529)); // 4
		System.out.println(solution(20)); // 1
		System.out.println(solution(13));// 1
		System.out.println(solution(15));// 0
		System.out.println(solution(32));// 0
	}

	private static int solution(int N) {
		String str = Integer.toBinaryString(N);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				if ((i - 1 >= 0 && str.charAt(i - 1) == '0')
						|| (i + 1 < str.length() && str.charAt(i + 1) == '0'))
					list.add(i);
			}
		}
		if (list.size() <= 1)
			return 0;

		int ans = 0;

		for (int i = 0; i < list.size() - 1; i++) {
			int tmp = list.get(i + 1) - list.get(i);
			if (ans < tmp)
				ans = tmp;
		}
		return ans - 1;
	}
}