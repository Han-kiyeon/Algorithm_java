package Algorithm;

import java.util.Arrays;

public class ComparableTest {
	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x)
				return Integer.compare(this.y, o.y);
			else
				return Integer.compare(this.x, o.x);
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) {
		Point[] p = { new Point(4, 3), new Point(1, 2), new Point(4, 1), new Point(2, 6) };
		System.out.println("정렬 전: " + Arrays.toString(p));
		Arrays.sort(p);
		System.out.println("정렬 후: " + Arrays.toString(p));
	}
}
