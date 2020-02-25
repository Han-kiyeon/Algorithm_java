import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main_백준_16235_나무재테크_서울8반_한기연 {
	static int N, M, K;
	static int[][] robot, land;

	static PriorityQueue<Tree> tree;

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class Tree implements Comparable<Tree> {
		int r, c, age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		public int compareTo(Tree t) {
			return this.age > t.age ? 1 : -1;
		}

		public String toString() {
			return "(r=" + r + ", c=" + c + ", age=" + age + ")";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() + 1; // 땅의 크기 1base
		int M = sc.nextInt(); // 나무 수
		int K = sc.nextInt(); // 년 수
		robot = new int[N][N];
		land = new int[N][N];

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				robot[i][j] = sc.nextInt();// 로봇이 추가하는 양분
				land[i][j] = 5; // 초기 양분
			}
		}
//		for (int[] is : robot) {
//			System.out.println(Arrays.toString(is));
//		}
//		System.out.println();
//		for (int[] is : land) {
//			System.out.println(Arrays.toString(is));
//		}
//		System.out.println();
		tree = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			tree.offer(new Tree(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		ArrayList<Tree> dead = new ArrayList<>();
		ArrayList<Tree> alive = new ArrayList<>();
		for (int year = 0; year < K; year++) {
			// 봄
			//System.out.println("봄");
			while (!tree.isEmpty()) {
				Tree t = tree.poll();
				//System.out.println(t);
				if (land[t.r][t.c] < t.age) {// 죽는다
					//System.out.println("dead");
					dead.add(t);
				} else {
					//System.out.println("alive");
					land[t.r][t.c] -= t.age; // 양분을 먹고
					t.age++; // 한살도 먹고
					alive.add(t);
				}
			}
			//System.out.println("여름");
			// 여름
			for (int i = 0; i < dead.size(); i++) {
				Tree t = dead.get(i);
				//System.out.println(t);
				// 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다
				land[t.r][t.c] += t.age / 2;
			}
			dead.clear();
			//System.out.println("가을");
			// 가을
			for (int i = 0; i < alive.size(); i++) {
				Tree t = alive.get(i);
				//System.out.println(t);
				if (t.age % 5 != 0) {// 번식하지 못하는 나무
					//System.out.println("No");
					tree.offer(t);
				} else {
					//System.out.println("Yes");
					tree.offer(t);
					for (int k = 0; k < 8; k++) {
						int r = t.r + dr[k];
						int c = t.c + dc[k];
						if (1 <= r && r < N && 1 <= c && c < N) {
							Tree nt = new Tree(r, c, 1);
							//System.out.println("    " + nt);
							tree.offer(nt);
						}
					}
				}
			}
			alive.clear();

			// 겨울
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < N; j++) {
					land[i][j] += robot[i][j];
				}
			}
		}
		System.out.println(tree.size());

	}
}