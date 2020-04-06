package BOJ.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Silver4_1764_듣보잡 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();

		for (int i = 0; i < N; i++) {
			set1.add(sc.next());
		}

		for (int i = 0; i < M; i++) {
			set2.add(sc.next());
		}

		ArrayList<String> ans = new ArrayList<>();

		for (String string : set1) {
			if (set2.contains(string))
				ans.add(string);
		}

		Collections.sort(ans);

		System.out.println(ans.size());
		for (String string : ans) {
			System.out.println(string);
		}
	}
}