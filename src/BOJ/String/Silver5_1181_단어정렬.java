package BOJ.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.String
 * @FileName : Silver5_1181_단어정렬.java
 *
 * @Date : 2020. 4. 2.
 * @작성자 : 한기연
 * @메모리 : 35944 kb
 * @실행시간 : 720 ms
 *
 * @Blog : __
 **/
public class Silver5_1181_단어정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(sc.next());
		}
		ArrayList<String> data = new ArrayList<>(set);
		Collections.sort(data, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length())
					return o1.length() - o2.length();
				else
					return o1.compareTo(o2);
			}
		});
		for (String string : data) {
			System.out.println(string);
		}
	}
}