package ETC;
import java.util.Arrays;
import java.util.Scanner;

public class Kakao_비밀지도 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 18 };
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			String str1 = Integer.toBinaryString(arr1[i]);
			String str2 = Integer.toBinaryString(arr2[i]);
			int len1 = str1.length();
			int len2 = str2.length();
			while (len1 != n) {
				str1 = "0" + str1;
				len1++;
			}
			while (len2 != n) {
				str2 = "0" + str2;
				len2++;
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < answer.length; j++) {
				if (str1.charAt(j) == '1' || str2.charAt(j) == '1')
					sb.append("#");
				else
					sb.append(" ");
			}
			answer[i] = sb.toString();

		}
		return answer;
	}
}