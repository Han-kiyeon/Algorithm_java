import java.io.*;
import java.util.*;

public class Main_백준_5427_불_서울8반_한기연2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/백준_5427_불.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			Queue<int[]> my = new LinkedList<>();
			Queue<int[]> fire = new LinkedList<>();

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				// map[i]= str.toCharArray();
				for (int j = 0; j < w; j++) {
					char tmp = str.charAt(j);
					map[i][j] = tmp;
					if (tmp == '@')
						my.add(new int[] { i, j });
					else if (tmp == '*')
						fire.add(new int[] { i, j });
				}
			}
			for (char[] x : map)
				System.out.println(Arrays.toString(x));
			System.out.println();

		} // end of TC
	}// end of main
}
