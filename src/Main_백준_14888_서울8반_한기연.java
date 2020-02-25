import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_14888_서울8반_한기연 {
	static int min, max;
	static int[] arr, OP;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[2 * N - 1];

		for (int i = 0; i < arr.length; i += 2) {
			arr[i] = sc.nextInt();
		}

		OP = new int[N - 1];
		int arrIdx = 0, tmp = 0;
		for (int i = 0; i < 4; i++) {
			tmp++;
			for (int j = sc.nextInt(); j > 0; j--) {
				OP[arrIdx++] = tmp;
			}
		}
		
		visit = new boolean[N-1];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		permu(N - 1, N - 1, 1);
		System.out.println(max);
		System.out.println(min);

	}
	//순열
	private static void permu(int n, int r, int depth) {
		if (depth == r+1) {
			calc();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				arr[2 * depth - 1] = OP[i];
				permu(n, r, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static void calc() {
		int res = arr[0];
		for (int i = 2; i < arr.length; i+=2) {
			switch (arr[i-1]) {
			case 1:	res +=arr[i];	break;
			case 2:	res -=arr[i];	break;
			case 3:	res *=arr[i];	break;
			case 4:	res /=arr[i];	break;
			}
		}	
		
		if(max<res) max = res;
		if(min>res) min = res;				
	}
}
