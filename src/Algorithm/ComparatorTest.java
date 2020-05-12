package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) {
		Point[] p = { new Point(4, 3), new Point(1, 2), new Point(4, 1), new Point(2, 6) };
		System.out.println("정렬 전: " + Arrays.toString(p));
		Arrays.sort(p,new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x == o2.x)
					return Integer.compare(o1.y, o2.y);
				else
					return Integer.compare(o1.x, o2.x);
			}
		});
		System.out.println("정렬 후: " + Arrays.toString(p));
	}
}
