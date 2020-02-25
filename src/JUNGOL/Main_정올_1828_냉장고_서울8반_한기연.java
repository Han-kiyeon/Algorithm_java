/*		
4
-15 5
-10 36
10 73
27 44

2

==============================
91
3 5
12 37
16 23
140 143
437 522
55 95
608 2898
4614 5026
5729 9521
0 0
0 6
4 25
-24 15
112 297
480 603
52 733
1712 2578
593 2453
695 769
0 0
-9 0
7 22
23 73
-161 113
152 454
193 778
827 2057
1287 7767
2439 2794
0 0
1 3
-42 10
18 39
230 269
86 339
210 817
2673 3451
3054 3717
4176 4969
0 0
-3 1
-43 37
52 54
76 202
258 553
51 647
2066 2387
3100 4254
2391 7004
0 0
0 2
-49 21
-73 58
161 217
423 651
316 682
345 2107
2454 6382
5106 9322
0 0
-9 7
48 49
-36 3
-122 110
635 710
220 292
2013 3319
4155 6749
2609 9557
0 0
3 7
2 12
-94 62
318 368
412 665
591 800
810 1967
3365 4434
3019 3715
0 0
2 3
14 26
49 54
329 364
174 370
766 878
68 2986
3920 6792
832 5078
0 0
-9 4


CPU Result
18



==============
71
1 7
-45 27
-70 46
170 266
130 459
19 450
1266 3455
1569 3487
4283 8422
0 0
1 6
-34 25
-25 23
28 113
195 461
651 683
554 1256
2386 3166
902 6891
0 0
1 3
-35 22
-57 3
31 380
52 443
329 629
633 3555
1318 6556
2824 9992
0 0
4 7
-47 41
46 80
290 391
91 612
181 619
1420 2064
2076 7747
842 9402
0 0
7 8
21 22
62 99
21 257
70 711
417 811
982 3010
5364 7186
6029 7532
0 0
8 8
30 39
23 37
259 281
-116 106
592 761
2102 3478
3045 5549
3144 7916
0 0
1 3
36 43
-40 37
12 206
325 712
347 573
96 1229
4189 5845
8675 9374
0 0
0 1


CPU Result
15



21
-9 8
14 44
50 72
-214 186
155 450
396 442
380 1484
1506 3037
544 3035
0 0
6 9
-33 17
-53 3
23 238
196 457
911 981
2606 3953
1620 6859
3754 6437
0 0
-5 0


CPU Result
8


 */


package JUNGOL;

import java.io.*;
import java.util.*;

public class Main_정올_1828_냉장고_서울8반_한기연 {
	private static ArrayList<Tmp> list;
	private static ArrayList<Tmp> ans;

	private static class Tmp {
		int low;
		int high;

		public Tmp(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		public boolean range(int i) {
			if (this.low <= i && i <= this.high)
				return true;
			return false;
		}

		public int getLow() {
			return low;
		}

		public void setLow(int low) {
			this.low = low;
		}

		public int getHigh() {
			return high;
		}

		public void setHigh(int high) {
			this.high = high;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("(low=");
			builder.append(low);
			builder.append(", high=");
			builder.append(high);
			builder.append(")");
			return builder.toString();
		}
	}

	private static void check(int x) {
		boolean flag = true;
		for (int i = 0; i < ans.size(); i++)// 현재 냉장고 수.
			for (int j = list.get(x).low; j <= list.get(x).high; j++)// 화학물질의 적정 온도
				if (ans.get(i).range(j)) {
					flag = false; // 필요 없어..
					if (ans.get(i).low < list.get(x).low)
						ans.get(i).setLow(list.get(x).low);
					if (ans.get(i).high > list.get(x).high)
						ans.get(i).setHigh(list.get(x).high);
				}

		if (flag)
			ans.add(list.get(x));// 만들어줘
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 화학 물질 수

		list = new ArrayList<>(); // 화학물질의 적정온도를 담을 리스트

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Tmp(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list, new Comparator<Tmp>() {
			@Override
			public int compare(Tmp o1, Tmp o2) {
				return Integer.compare(o1.getHigh(), o2.getHigh());
			}
		});
		//System.out.println(list);
	
		ans = new ArrayList<>(); // 냉장고
		ans.add(list.get(0));

		for (int i = 1; i < list.size(); i++) // 화학물질의 수
			check(i); // 냉장고 새로 만들래?

		System.out.println(ans.size());
		// System.out.println(ans);
	}
}
