
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_백준_17822_원판돌리기_서울8반_윤건희 {
	static int n, m;
	static boolean[][] visit;
	static boolean chk, find;
	static LinkedList<Integer>[] listarr;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void dfs(int i, int j) {
		if (listarr[i].get(j) == 0)
			return;
		System.out.println(i + " " + j);
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (nj == -1)
				nj = m - 1;
			if (nj == m)
				nj = 0;
			if (ni >= 0 && ni < n && !visit[ni][nj]) {
				if (listarr[i].get(j) == listarr[ni].get(nj)) {
					System.out.println(">>>" + k + ": " + ni + " " + nj);
					chk = true;
					find = true;
					visit[ni][nj] = true;
					dfs(ni, nj);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());// n개 원판
		m = Integer.parseInt(st.nextToken());// m개의 수
		int t = Integer.parseInt(st.nextToken());// 총 몇번 시행?
		listarr = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			listarr[i] = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				listarr[i].add(Integer.parseInt(st.nextToken()));
			} // n개의 원판에 m개의 수들 입력 끝
		}

		for (LinkedList<Integer> is : listarr) {
			System.out.println(is);
		}
		System.out.println();

		for (int cmd = 1; cmd <= t; cmd++) {// 명령어 개수
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());// x의 배수들
			int d = Integer.parseInt(st.nextToken());// 0=시계 1=반시계
			int k = Integer.parseInt(st.nextToken());// k번 돌리기
			System.out.println("cmd:" + x + " " + d + " " + k);
			System.out.println("Before");
			for (LinkedList<Integer> is : listarr) {
				System.out.println(is);
			}
			System.out.println();

			boolean clock = false;
			if (d == 0)
				clock = true;// true면 시계방향
			for (int i = 0; i < n; i++) {
				if ((i + 1) % x == 0) {// x배수의 원판들을
					for (int rotate = 0; rotate < k; rotate++) {
						if (clock) {// 시계방향이면?
							listarr[i].addFirst(listarr[i].pollLast());
						} else if (!clock) {
							listarr[i].addLast(listarr[i].pollFirst());
						}
						for (LinkedList<Integer> is : listarr) {
							System.out.println(is);
						}
						System.out.println();
					}
				}

			} // k번 돌리기
			System.out.println("After");

			for (LinkedList<Integer> is : listarr) {
				System.out.println(is);
			}
			System.out.println();

			// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡdfs
			chk = false;
			visit = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visit[i][j]) { // 방문한적이 없을때
						find = false;
						visit[i][j] = true; // 방문처리
						dfs(i, j);
						if (!find)// 주변에 같은 값이 없으면
							visit[i][j] = false; // 방문처리 해제
					}
				}
			}
			// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡdfs

			if (chk) {// 동일한 숫자가 있었으면
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (visit[i][j])
							listarr[i].set(j, 0);
					}
				}
			} else if (!chk) {// 동일한 숫자가 없었으면
				int cnt = 0;
				int s = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (listarr[i].get(j) != 0) {
							cnt++;
							s += listarr[i].get(j);
						}
					}
				}
				if (cnt > 0) {
					double avg = s / (double) cnt;
					System.out.println(avg);
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < m; j++) {
							if (listarr[i].get(j) > avg && listarr[i].get(j) != 0)
								listarr[i].set(j, listarr[i].get(j) - 1);
							else if (listarr[i].get(j) < avg && listarr[i].get(j) != 0)
								listarr[i].set(j, listarr[i].get(j) + 1);
						}
					}
				}

			} // 없었을떄 끝
			System.out.println("///////////////////////////////////////////////////////////");
		} // 시행 횟수 끝

		for (LinkedList<Integer> is : listarr) {
			System.out.println(is);
		}
		System.out.println();

		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += listarr[i].get(j);
			}
		}
		System.out.println(sum);
	}
}