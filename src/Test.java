import java.awt.Point;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[][] map = new int[7][7];
		int N = 7;
		int x = 1, y = 4, d1 = 3, d2 = 2;
		Point[] p = new Point[4];
		p[0] = new Point(x, y);
		p[1] = new Point(x + d1 + d2, y + d2 - d1);
		p[2] = new Point(x + d1, y - d1);
		p[3] = new Point(x + d2, y + d2);
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (r + c >= Math.abs((0) - (x)) + Math.abs((0) - (y)) &&
						r + c <= Math.abs((0) - (x + d1 + d2)) + Math.abs((0) - (y + d2 - d1)) &&
						r + (N - c) <= Math.abs((0) - (x + d1 + d2)) + Math.abs((N) - (y + d2 - d1)) &&
						r + (N - c) >= Math.abs((0) - (x)) + Math.abs((N) - (y))
				) { //
					map[r][c] = 5;
				}
			}
		}

		for (int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
	}
}