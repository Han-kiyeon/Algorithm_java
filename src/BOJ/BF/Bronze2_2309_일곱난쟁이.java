package BOJ.BF;
import java.util.Arrays;
import java.util.Scanner;

public class Bronze2_2309_일곱난쟁이 {
	static int[] data = new int[9];
	static boolean[] res = new boolean[9];
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		select(0, 0);
	}

	private static void select(int start, int depth) {
		if (depth == 2 && !flag) {
			int sum = 0;
			for (int i = 0; i < 9; i++)
				if (!res[i])
					sum += data[i];

			if (sum == 100) {
				for (int i = 0; i < 9; i++)
					if (!res[i])
						System.out.println(data[i]);
				flag = true;
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			if (!res[i]) {
				res[i] = true;
				select(i, depth + 1);
				res[i] = false;
			}
		}
	}
}
