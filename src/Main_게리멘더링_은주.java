import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_게리멘더링_은주 {

	public static int[] par;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 구역별 인구 수를 저장
		int[] man = new int[N];
		int min = Integer.MAX_VALUE / 2;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			man[i] = Integer.parseInt(st.nextToken());
		}
		// 구역간 거리를 저장하는 인접배열
		boolean[][] V = new boolean[N][N];
		// Copy 인접배열
		boolean[][] vil = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int dest = Integer.parseInt(st.nextToken()) - 1;
				V[i][dest] = true;
				V[dest][i] = true;
			}
		}

		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		// bit를 사용하여 둘로 나누는 모든 경우를 탐색
		// 000000 과 111111 의 경우는 제거
		// a, b ArrayList에 나누어 저장
		loop: for (int bit = 1; bit < (1 << N - 1); bit++) {
			// System.out.println(Integer.toBinaryString(bit));
			a.clear();
			b.clear();
			for (int i = 0; i < N; i++) {
				System.arraycopy(V[i], 0, vil[i], 0, N);
			}
			for (int i = 0; i < N; i++) {
				if ((bit & (1 << i)) == 0)
					b.add(i);
				else
					a.add(i);
			}

			// a와 b의 구역간 연결된 간선 모두 지워주기
			// (Copy 인접배열에서 진행)
			for (int i = 0; i < a.size(); i++) {
				for (int j = 0; j < b.size(); j++) {
					vil[a.get(i)][b.get(j)] = false;
					vil[b.get(j)][a.get(i)] = false;
				}
			}

//			for (boolean[] v : vil)
//				System.out.println(Arrays.toString(v));

			// Union Find 작업
			par = new int[N];
			for (int i = 0; i < N; i++) {
				par[i] = i;
			}
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (vil[i][j] && par(i) != par(j))
						union(i, j);
				}
			}

			// a, b ArrayList를 순회하며 지역구 내 모든 구역이 연결되었는지
			// 확인하는 작업 (parent 가 하나라도 다르면 다음 bit 경우의수로 넘어감)
			// System.out.println(Arrays.toString(par));
			int s1 = man[a.get(0)], s2 = man[b.get(0)];
			for (int i = 1; i < a.size(); i++) {
				if (par(a.get(i - 1)) != par(a.get(i))) {
					continue loop;
				}
				s1 += man[a.get(i)];
			}

			for (int i = 1; i < b.size(); i++) {
				if (par(b.get(i - 1)) != par(b.get(i))) {
					continue loop;
				}
				s2 += man[b.get(i)];
			}
			// 두 구역간 인구 차이 최소값 갱신
			min = Math.min(min, Math.abs(s1 - s2));
		}

		// 나눌 수 있는 경우가 없다면
		if (min == Integer.MAX_VALUE / 2)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	public static int par(int i) {
		if (par[i] == i)
			return i;
		return par(par[i]);
	}

	public static void union(int i, int j) {
		int pi = par(i);
		int pj = par(j);

		if (pi > pj)
			par[pi] = pj;
		else
			par[pj] = pi;
	}
}
