package BOJ.Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.Simulation
 * @FileName : Gold3_17143_낚시왕.java
 *
 * @Date : 2020. 6. 1.
 * @작성자 : 한기연
 * @메모리 : 66352 kb
 * @실행시간 : 1660 ms
 *
 * @Blog : __
 **/
public class Gold3_17143_낚시왕 {
	static int R, C, M;

	static class Shark implements Comparable<Shark> {
		// (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			if (this.c != o.c)
				return this.c - o.c;
			if (this.r != o.r)
				return this.r - o.r;
			return o.z - this.z;
		}

		public void changeDir() {
			switch (this.d) {
				case 1:
					this.d = 2;
					break;
				case 2:
					this.d = 1;
					break;
				case 3:
					this.d = 4;
					break;
				case 4:
					this.d = 3;
					break;
			}
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();

		ArrayList<Shark> s = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			s.add(new Shark(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		Collections.sort(s);

		int ans = 0; // 낚시왕이 잡은 상어 크기의 합
		for (int i = 0; i < C; i++) {
			// i는 낚시왕의 위치
			for (int j = 0; j < s.size(); j++) {
				if (s.get(j).c == i) {
					ans += s.get(j).z;
					s.remove(j);
					break;
				}
			}
			for (int j = 0; j < s.size(); j++) {
				Shark now = s.get(j);
				int speed = now.s;
				while (speed-- > 0) {
					switch (now.d) {
						case 1:
							now.r--;
							break;
						case 2:
							now.r++;
							break;
						case 3:
							now.c++;
							break;
						case 4:
							now.c--;
							break;
					}
					if (now.c == -1 || now.c == C || now.r == -1 || now.r == R) {
						now.changeDir();
						speed += 2;
					}
				}
			}
			Collections.sort(s);
			for (int j = 0; j < s.size() - 1; j++) {
				Shark now = s.get(j);
				Shark next = s.get(j + 1);
				if (now.r == next.r && now.c == next.c) {
					s.remove(j + 1);
					j--;
				}
			}
		}
		System.out.println(ans);
	}
}