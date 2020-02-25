package JUNGOL;

import java.io.*;
import java.util.*;

public class Main_정올_1863_종교_서울8반_한기연 {
	static int[] disjoint;

	public static void makeSet(int n) {
		disjoint = new int[n + 1];
		for (int i = 1; i <= n; i++)
			disjoint[i] = i;
	}

	public static void union(int a, int b) {
		int i = findset(a);
		int j = findset(b);
		if (i < j)
			disjoint[j] = i;
		else
			disjoint[i] = j;
	}

	public static int findset(int a) {
		if (disjoint[a] == a)
			return a;
		return disjoint[a] = findset(disjoint[a]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		makeSet(N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (disjoint[i] == i)
				result++;
		}
		
		System.out.println(result);
	}// end of main
}