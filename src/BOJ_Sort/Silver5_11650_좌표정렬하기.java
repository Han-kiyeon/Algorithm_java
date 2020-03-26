package BOJ_Sort;
import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ_Sort
 * @FileName : Silver5_11650_좌표정렬하기.java
 *
 * @Date : 2020. 4. 2.
 * @작성자 : 한기연
 * @메모리 : 179020 kb
 * @실행시간 : 1352 ms
 *
 * @Blog : __
 **/
public class Silver5_11650_좌표정렬하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 점의 개수
		Point[] points = new Point[N];

		for (int i = 0; i < N; i++) {
			points[i] = new Point(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(points, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x != o2.x)
					return o1.x - o2.x;
				else
					return o1.y - o2.y;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (Point point : points) {
			sb.append(point.x).append(" ").append(point.y).append("\n");
		}
		System.out.println(sb);
	}
}