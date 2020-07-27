package Programmers;

import java.awt.Point;

public class Kakao2020_키패드누르기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
		System.out.println(solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left"));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right"));
	}

	private static String solution(int[] numbers, String hand) {
		Point[] nums = new Point[10];
		nums[0] = new Point(3, 1);
		nums[1] = new Point(0, 0);
		nums[2] = new Point(0, 1);
		nums[3] = new Point(0, 2);
		nums[4] = new Point(1, 0);
		nums[5] = new Point(1, 1);
		nums[6] = new Point(1, 2);
		nums[7] = new Point(2, 0);
		nums[8] = new Point(2, 1);
		nums[9] = new Point(2, 2);
		Point L = new Point(3, 0);
		Point R = new Point(3, 2);

		StringBuilder sb = new StringBuilder();
		for (int num : numbers) {
			if (num == 1 || num == 4 || num == 7) {
				L.x = nums[num].x;
				L.y = nums[num].y;
				sb.append("L");
			} else if (num == 3 || num == 6 || num == 9) {
				R.x = nums[num].x;
				R.y = nums[num].y;
				sb.append("R");
			} else {
				int disL = Math.abs(L.x - nums[num].x) + Math.abs(L.y - nums[num].y);
				int disR = Math.abs(R.x - nums[num].x) + Math.abs(R.y - nums[num].y);
				if (disL == disR) {
					if (hand.equals("right")) {
						R.x = nums[num].x;
						R.y = nums[num].y;
						sb.append("R");
					} else {
						L.x = nums[num].x;
						L.y = nums[num].y;
						sb.append("L");
					}
				} else {
					System.out.println(disL + " " + disR);
					if (disR < disL) {
						R.x = nums[num].x;
						R.y = nums[num].y;
						sb.append("R");
					} else {
						L.x = nums[num].x;
						L.y = nums[num].y;
						sb.append("L");
					}
				}
			}
		}
		return sb.toString();
	}
}
