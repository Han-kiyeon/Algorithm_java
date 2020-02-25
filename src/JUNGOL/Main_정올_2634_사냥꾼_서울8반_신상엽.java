package JUNGOL;
import java.io.*;
import java.util.*;

public class Main_정올_2634_사냥꾼_서울8반_신상엽 {
	static int M, N, L;
	static List<Integer> mList = new ArrayList<>();

	static int len(int r, int c, int mc) {
		return Math.abs(mc - c) + r;
	}

	static class Info implements Comparable<Info> {
		int r, c;

		public Info(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.r + this.c, o.r + o.c);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			mList.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(mList);

		PriorityQueue<Info> pqAni = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if (r <= L) {
				pqAni.add(new Info(r, c));
			}
		}

		int result = 0;
		for (int i = 0; i < mList.size(); i++) {
			int cnt = 0;
			while (!pqAni.isEmpty()) {
				Info now = pqAni.peek();
				if (len(now.r, now.c, mList.get(i)) <= L) {
					cnt++;
					pqAni.poll();
				} else {
					if (now.c < mList.get(i)) {
						pqAni.poll();
					} else {
						break;
					}
				}
			}
			result += cnt;
		}

		System.out.println(result);
	}

}
