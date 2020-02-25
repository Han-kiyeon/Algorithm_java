
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크 {
	public static boolean v[];
	public static Queue<Integer> t1, t2, q1, q2;
	static int N, team1, team2, dap;
	static int[][] team;

	public static void Comb(int arr[], boolean v[], int ss, int n, int r) {
		if (r == 0) {

			int s[] = new int[N / 2];
			boolean v1[] = new boolean[N / 2];
			int l[] = new int[N / 2];
			boolean v2[] = new boolean[N / 2];

			int scnt = 0, lcnt = 0;
			for (int si = 0; si < N; si++) {
				if (v[si])
					s[scnt++] = arr[si];
				else
					l[lcnt++] = arr[si];
			}
			//System.out.println("s= " + Arrays.toString(s));
			team1 = 0;
			Comb2(s, v1, 2, 0, 0, true);
			//System.out.println("l= " + Arrays.toString(l));
			team2 = 0;
			Comb2(l, v2, 2, 0, 0, false);
			if (dap > Math.abs(team1 - team2))
				dap = Math.abs(team1 - team2);
			return;
		} else {
			for (int i = ss; i < n; i++) {
				v[i] = true;
				Comb(arr, v, i + 1, n, r - 1);
				v[i] = false;
			}
		}

	}

	public static void Comb2(int[] data, boolean[] v, int r, int start, int depth, boolean b) {
		if (depth == r) {
			// System.out.println(Arrays.toString(v));
			int[] res = new int[2];
			int idx = 0;
			for (int i = 0; i < v.length; i++) {
				if (v[i]) {
					res[idx++] = data[i];
				}
			}
			//System.out.println(Arrays.toString(res));

			if (b) {
				team1 += team[res[0]-1][res[1]-1];
				team1 += team[res[1]-1][res[0]-1];
			}else {
				team2 += team[res[0]-1][res[1]-1];
				team2 += team[res[1]-1][res[0]-1];
			}

			return;
		} else {
			for (int i = start; i < data.length; i++) {
				if (!v[i]) {
					v[i] = true;
					Comb2(data, v, r, i, depth + 1, b);
					v[i] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		int arr[] = new int[N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
			arr[i] = i + 1;
		} // 입력
		dap = Integer.MAX_VALUE;
		Comb(arr, v, 0, N, N / 2);

		System.out.println(dap);
//		int size = t1.size() / 2;
//		int dap = Integer.MAX_VALUE;
//		for (int i = 0; i < size; i += 2) {
//			int s[] = new int[N / 2];
//			boolean v1[] = new boolean[N / 2];
//			int l[] = new int[N / 2];
//			boolean v2[] = new boolean[N / 2];
//			for (int si = 0; si < N / 2; si++) {
//				s[si] = t1.poll();
//				l[si] = t2.poll();
//			}
//			Comb2(s, v1, 0, N / 2, 2, true);
//			Comb2(l, v2, 0, N / 2, 2, false);
//			int start = 0, link = 0;
//			for (int j = 0; j <= q1.size(); j++) {
//				int x1 = q1.poll() - 1;
//				int y1 = q1.poll() - 1;
//				int x2 = q2.poll() - 1;
//				int y2 = q2.poll() - 1;
//				start += team[x1][y1] + team[y1][x1];
//				link += team[x2][y2] + team[y2][x2];
//			}
//			dap = dap > Math.abs(start - link) ? Math.abs(start - link) : dap;
//
//		}
//		System.out.println(dap);
	}

}
