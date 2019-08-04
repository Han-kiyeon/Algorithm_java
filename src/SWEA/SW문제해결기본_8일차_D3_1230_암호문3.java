package SWEA;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class SW문제해결기본_8일차_D3_1230_암호문3 {

	private static Scanner sc;

	private static LinkedList<Integer> list;
	private static int N; // 원본 암호문의 길이
	private static int commandN; // 명령어의 갯수
	private static int x, y, s; // 명령어 시작&끝
	// private static LinkedList<Integer> nums;// 삽입될 암호

	private static void insert(int x, int y) {
		for (int j = 0; j < y; j++)
			list.add(x + j, sc.nextInt());
	}

	private static void delete(int x, int y) {
		for (int i = 0; i < y; i++)
			list.remove(x);
	}

	private static void add(int y) {
		for (int i = 0; i < y; i++)
			list.add(sc.nextInt());
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1230_D3_암호문3.txt"));
		sc = new Scanner(System.in);

		int T = 10; // 10개의 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 원본 암호문의 길이
			list = new LinkedList<>();
			for (int i = 0; i < N; i++)
				list.add(sc.nextInt());
			commandN = sc.nextInt(); // 명령어의 갯수
			for (int i = 0; i < commandN; i++) {
				switch (sc.next().charAt(0)) {
				// (삽입)'I' x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다
				case 'I':
					x = sc.nextInt();
					y = sc.nextInt();
					insert(x, y);
					break;
				// D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.
				case 'D':
					x = sc.nextInt();
					y = sc.nextInt();
					delete(x, y);
					break;
				// A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다.
				case 'A':
					y = sc.nextInt();
					add(y);
					break;
				}
			}

			System.out.print("#" + tc);
			for (int i = 0; i < 10; i++)
				System.out.print(" " + list.get(i));
			System.out.println();
		}

		sc.close();
	}
}