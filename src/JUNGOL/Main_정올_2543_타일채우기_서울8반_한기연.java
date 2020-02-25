package JUNGOL;

import java.util.Arrays;
import java.util.Scanner;

public class Main_정올_2543_타일채우기_서울8반_한기연 {
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 화장실 바닥의 한변의 길이
		map = new int[N][N];
		int[] point = { sc.nextInt(), sc.nextInt() }; // 구멍의 좌표
		map[point[0]][point[1]] = -1;
		System.out.println(Arrays.toString(point));

		divison(0, 0, N);


		sc.close();
	}// end of main

	private static void divison(int x, int y, int n) {
		System.out.println("[Divison ] x= " + x + ", y= " + y + ", n= " + n);
		int half = n / 2;
		if (n == 2) {
			conquest(x, y, n);
			return;
		}
		divison(x, y, half);
		divison(x, y + half, half);
		divison(x + half, y, half);
		divison(x + half, y + half, half);
	}

	private static void conquest(int x, int y, int n) {
		System.out.println("[Conquest] x= " + x + ", y= " + y + ", n= " + n);
		
	}
}
