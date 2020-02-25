package JUNGOL;
import java.io.*;
import java.util.*;

public class Main_정올_1011_소수369_서울8반_한기연 {
	public static int Bcnt, Wcnt;
	public static int[][] matrix;
	public static void sol(int N, int i, int j) {
		boolean Bflag = true;
		boolean Wflag = true;

		for (int ni = i; ni < i + N; ni++)
			for (int nj = j; nj < j + N; nj++) {
				if (matrix[ni][nj] == 0)
					Bflag = false;
				else if (matrix[ni][nj] == 1) 
					Wflag = false;		
			}
		if (Bflag) {
			Bcnt++;
			return;
		}
		if (Wflag) {
			Wcnt++;
			return;
		}
		
		int M = N / 2;
		if(M==0)
			return;
		
		sol(M, i + M, j + M); // 우하
		sol(M, i, M + j); // 우상
		sol(M, i, j); // 좌상
		sol(M, i + M, j); // 좌하
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}

		Bcnt = 0;
		Wcnt = 0;

		sol(N, 0, 0);

		System.out.println(Wcnt);
		System.out.println(Bcnt);


	}
}
