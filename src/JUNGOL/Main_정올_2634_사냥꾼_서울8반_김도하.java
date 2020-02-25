package JUNGOL;
import java.io.*;
import java.util.*;

public class Main_정올_2634_사냥꾼_서울8반_김도하 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 사대 수
		int N = Integer.parseInt(st.nextToken()); // 동물 수
		int L = Integer.parseInt(st.nextToken()); // 사정거리

		int gun[] = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			gun[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(gun);

		int answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // i번째 동물의 x좌표
			int start = 0;
			int end = M - 1;
			while (start < end) {
				int mid = (start + end) / 2;
				if (gun[mid] < x)
					start = mid + 1;
				else if (gun[mid] > x)
					end = mid - 1;
				else
					break;
			}
			int min = Integer.MAX_VALUE;
			int mid = (start + end) / 2;
			for (int j = -1; j <= 1; j++) {
				if (mid + j >= 0 && mid + j < M) {
					if (min > Math.abs(gun[mid + j] - x))
						min = Math.abs(gun[mid + j] - x);
				}
			}
			if (min + Integer.parseInt(st.nextToken()) <= L)
				answer++;
		}
		System.out.println(answer);
	}
}