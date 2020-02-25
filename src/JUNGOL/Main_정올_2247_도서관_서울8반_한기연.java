package JUNGOL;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_정올_2247_도서관_서울8반_한기연 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] times = new int[n][2];
		for (int i = 0; i < n; i++) {
			times[i][0] = sc.nextInt();
			times[i][1] = sc.nextInt();
		}
		sc.close();

		Arrays.sort(times, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] <= b[0] ? -1 : 1;
			}
		});


		int inTime = 0;
		int outTime = 0;
		int[] in = new int[2];
		int[] out = new int[2];
		in = times[0];



		for (int i = 1; i < times.length; i++) {
			int[] time = times[i];


			if (in[1] < time[0]) {
				out[0] = in[1];
				out[1] = time[0];

				inTime = (inTime < in[1] - in[0]) ? in[1] - in[0] : inTime;
				outTime = (outTime < out[1] - out[0]) ? out[1] - out[0] : outTime;

				in = time;
			} else if (time[0] <= in[1]) {
				if (time[1] > in[1]) {
					in[1] = time[1];
				}
			}
		}

		inTime = (inTime < in[1] - in[0]) ? in[1] - in[0] : inTime;

		System.out.printf("%d %d\n", inTime, outTime);
	}

}