package BOJ_Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_2751_수정렬하기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] data = new boolean[2000001];

		for (int i = 0; i < N; i++) {
			data[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			if (data[i])
				sb.append(i - 1000000).append('\n');
		}
		System.out.println(sb);
	}
}