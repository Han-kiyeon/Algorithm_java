import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_14888_연산자끼워넣기_서울8반_한기연 {
	static boolean[] visit;
	static int[] numbers;
	static int[] op;
	static int n, max, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];

		for (int i = 0; i < n; i++)
			numbers[i] = sc.nextInt();

		op = new int[n - 1];
		int idx = 0;
		for (int i = 0; i < 4; i++)
			for (int j = sc.nextInt(); j > 0; j--)
				op[idx++] = i + 1;

		max = Integer.MIN_VALUE;	min = Integer.MAX_VALUE;
		visit = new boolean[n - 1];

		solve(0, 1, numbers[0], 0);
		System.out.println(max);	System.out.println(min);

	}
	
	public static void solve(int v, int idx, int num, int len) {
		int result = 0;
		if (len == n - 1) {
			if (num > max)	max = num;
			if (num < min)	min = num;
			return;
		}
		
		for (int i = 0; i < n - 1; i++) {
			if (!visit[i]) {
				visit[i] = true;
				switch (op[i]) {
				case 1:	result = num + numbers[idx];	break;
				case 2:	result = num - numbers[idx];	break;
				case 3:	result = num * numbers[idx];	break;
				case 4:	result = num / numbers[idx];	break;
				}
				solve(i, idx + 1, result, len + 1);
				visit[i] = false;
			}
		}
	}
}
