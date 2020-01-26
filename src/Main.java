import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L, C;
	static char[] data, rlt;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();

		data = new char[C];
		for (int i = 0; i < C; i++) {
			data[i] = sc.next().charAt(0);
		}
		Arrays.sort(data);
		visit = new boolean[C];
		rlt = new char[L];
		solve(0, 0);
	}

	private static void solve(int idx, int depth) {
		if (depth == L) {
			check();
			return;
		}
		for (int i = idx; i < C; i++) {
			if (!visit[i]) {
				visit[i] = true;
				rlt[depth] = data[i];
				solve(i, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static void check() {
		String str = "aeiou";
		int ja = 0, mo = 0;
		for (int i = 0; i < L; i++) {
			if (str.contains("" + rlt[i]))
				mo++;
			else
				ja++;
		}
		if (mo >= 1 && ja >= 2)
			System.out.println(rlt);
	}
}
