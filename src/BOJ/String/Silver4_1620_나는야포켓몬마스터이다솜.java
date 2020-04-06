package BOJ.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Silver4_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		list.add(" ");
		for (int i = 1; i <= N; i++) {
			String now = sc.next();
			list.add(now);
			map.put(now, i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String now = sc.next();
			if ('0' <= now.charAt(0) && now.charAt(0) <= '9') {
				sb.append(list.get(Integer.parseInt(now))).append("\n");
			} else
				sb.append(map.get(now)).append("\n");
		}
		System.out.println(sb);
	}
}