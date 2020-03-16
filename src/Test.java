import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		list.add(1);

		list.add(2);
		list.add(2);

		list.add(3);
		list.add(3);
		list.add(3);

		list.add(4);
		list.add(6);
		list.add(7);

		System.out.println(lower_bound(list, 4));
		System.out.println(upper_bound(list, 4));
	}

	// lower bound는 찾고자 하는 값 이상이 처음 나타나는 위치
	private static int lower_bound(ArrayList<Integer> list, int val) {
		int start = 0;
		int end = list.size();
		int mid;
		while (start < end) {
			mid = (start + end) >> 1;
			if (list.get(mid) >= val) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	// upper bound는 찾고자 하는 값보다 큰 값이 처음으로 나타나는 위치
	private static int upper_bound(ArrayList<Integer> list, int val) {
		int start = 0;
		int end = list.size();
		int mid;
		while (start < end) {
			mid = (start + end) >> 1;
			if (list.get(mid) <= val) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}