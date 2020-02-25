
/*
140
5
100 30 100 40 50 60
5 10 4 11 7

16
3
1 3 5

 */

import java.io.*;
import java.util.*;

public class Main_백준_2651_자동차경주대회_서울8반_한기연3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 행 N
		int M = Integer.parseInt(st.nextToken()); // 열 M
		int R = Integer.parseInt(st.nextToken()); // 회전수 R

		int[][] matrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) 
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}	
	
		

	}// end of main
}
