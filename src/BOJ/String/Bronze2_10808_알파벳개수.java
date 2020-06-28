package BOJ.String;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.String
 * @FileName : Bronze2_10808_알파벳개수.java
 *
 * @Date : 2020. 6. 28.
 * @작성자 : 한기연
 * @메모리 : 14268	 kb
 * @실행시간 : 104 ms
 *
 * @Blog : __
 **/
public class Bronze2_10808_알파벳개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int[] ans = new int[26];
		for (int i = 0; i < str.length(); i++) {
			ans[str.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans.length; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}
}