import java.util.Arrays;

public class Test {
	static int[] data = new int[5];
	static boolean[] visit = new boolean[5];
	static int cnt = 0;

	public static void main(String[] args) {

		copy(0);
		System.out.println(cnt);
	}

	private static void copy(int depth) {
		if (depth == 5) {
			System.out.println(Arrays.toString(data));
			cnt++;
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!visit[i]) {
				visit[i] = true;
				data[depth] = i; 
				copy(depth + 1);
				visit[i] = false;
			}
		}
	}
}