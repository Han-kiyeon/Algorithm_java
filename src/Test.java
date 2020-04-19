import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[][] map = new int[10][10];

		int r = 3, c = 3;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(Math.abs(i-r)+Math.abs(j-c)<=3)
					map[i][j] = 1;
			}
		}

		for (int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
	}
}