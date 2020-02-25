package com.d3;

import java.io.*;
import java.util.*;

public class Solution_D3_1225_암호생성기_한기연 {
	private static Queue<Integer> queue;

	private static boolean cycle() {
		for (int i = 1; i <= 5; i++) {
			int tmp = queue.poll() - i;

			if (tmp <= 0) {
				queue.add(0);
				return false;
			} else
				queue.add(tmp);
			//System.out.println(queue);
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1225_D3_암호생성기.txt"));
		Scanner s = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			s.nextInt(); // tc

			queue = new LinkedList<>();
			for (int i = 0; i < 8; i++)
				queue.add(s.nextInt());
			

			//System.out.println(queue);

			while (cycle()) {
			}
			
			
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++)
				System.out.print(queue.poll() + " ");
			System.out.println();
		}

		s.close();
	}
}