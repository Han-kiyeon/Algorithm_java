package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_정올_1183_동전자판기하 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt(); // 자판기에서 구입하려는 물건의 값.
		int N = 6; // 동전의 종류 수 6개 >> 500, 100, 50, 10, 5, 1
		int[] type = { -1, 500, 100, 50, 10, 5, 1 };
		int[] coin = new int[N + 1];
		int[] result = new int[N + 1];
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			coin[i] = sc.nextInt();
			// sum += coin[i]*type[i];
		}

		// System.out.println(Arrays.toString(type));
		// System.out.println(Arrays.toString(coin));
		// System.out.println(Arrays.toString(result));

		for (int i = N; i >= 1; i--) {
			if ((W - type[i]) % type[i - 1] != 0) {
				W -= type[i];
				result[i]++;
				i++;
			} else if ((W - type[i]) % type[i - 1] == 0) {
				W -= type[i];
				result[i]++;
			}
			if (W <= 0)
				break;
		}
		for (int i = 1; i <= N; i++)
			System.out.print(result[i] + " ");
		System.out.println();

	}

}
