//Solution_D3_1208_Flatten_서울8반_한기연

package com.d3;

import java.util.*;
import java.io.*;

public class Solution_D3_1208_Flatten_서울8반_한기연 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		Scanner s = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int Dump = s.nextInt();

			int[] box = new int[100];

			for (int i = 0; i < 100; i++) {
				box[i] = s.nextInt();
			}

			Arrays.sort(box);

			for (; Dump != 0; Dump--) {
				box[0]++;
				box[99]--;
				Arrays.sort(box);
			}

			System.out.println("#" + tc + " " + (box[99] - box[0]));
		}
		s.close(); // Scanner close
	}
}