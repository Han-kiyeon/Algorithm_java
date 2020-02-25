/*		
=================
7
2 4
11 4
15 8
4 6
5 3
8 10
13 6

98

=================

 */

package JUNGOL;

import java.io.*;
import java.util.*;

public class Main_정올_1396_창고다각형_서울8반_한기연 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫 줄에는 기둥의 개수를 나타내는 정수 N이 주어진다.
		// N은 1이상 1,000 이하 이다. 그 다음 N개의 줄에는
		// 각 줄의 기둥의 왼쪽 면의 위치를 나타내는 정수 L과 높이를 나타내는
		// 정수 H가 한 개의 빈 칸을 사이에 두고 주어진다. L과 H는 둘 다 1 이상 1,000 이하 이다.
		int N = Integer.parseInt(br.readLine().trim()); // 기둥 개수 1 <= N<= 100
		int[] arr = new int[1001];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		// System.out.println(Arrays.toString(arr));

		int startIdx = -1;
		for (int i = 1; i <= 1000; i++)
			if (arr[i] != 0) {
				startIdx = i;
				break;
			}
		int endIdx = -1;
		for (int i = 1000; i >= 1; i--)
			if (arr[i] != 0) {
				endIdx = i;
				break;
			}
		int cnt = 0;
		int LMax = arr[startIdx];
		int RMax = arr[endIdx];
		while (startIdx != endIdx) {
			// int flag = 0;
			// while (flag++ != 100) {
			// System.out.println("--------"+flag);
			//System.out.println("startIdx= " + startIdx + " LMax= " + LMax);
			for (int i = startIdx + 1; i <= endIdx; i++) {
				if (LMax <= arr[i]) {
					// System.out.println("startIdx= "+startIdx+" LMax= "+LMax + " i=" + i + "
					// arr[i]=" + arr[i]);
					cnt += LMax * (i - startIdx);
					// System.out.println(LMax * (i - startIdx));
					LMax = arr[i];
					startIdx = i;
					break;
				}
			}
			// System.out.println("endIdx= "+endIdx+" RMax= "+RMax);
			for (int i = endIdx - 1; i >= startIdx; i--) {
				if (RMax <= arr[i]) {
					// System.out.println("endIdx= "+endIdx+" RMax= "+RMax + " i=" + i + " arr[i]="
					// + arr[i]);
					cnt += RMax * (endIdx - i);
					// System.out.println(RMax * (endIdx - i));
					RMax = arr[i];
					endIdx = i;
					break;
				}
			}

		}
		System.out.println(cnt+RMax);
	}
}
