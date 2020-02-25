import java.io.*;
import java.util.*;

public class Main_백준_2660_회장찾기_서울8반_한기연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] point = new int[N + 1];
		ArrayList<int[]> list = new ArrayList<int[]>();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x == -1)
				break;
			list.add(new int[] { x, y });
		}
		// for (int[] x : list)
		// System.out.println(Arrays.toString(x));

		for (int i = 1; i <= N; i++) {
			Queue<int[]> q = new LinkedList<>();
			boolean[] visit = new boolean[N + 1];
			q.add(new int[] { i, 0 });
			visit[i] = true;
			while (!q.isEmpty()) {
				int[] x = q.poll();
				point[i] = (point[i] > x[1]) ? point[i] : x[1];
				// System.out.println(x[0] + "-> ");
				for (int ii = 0; ii < list.size(); ii++) {
					if (x[0] == list.get(ii)[0])
						if (!visit[list.get(ii)[1]]) {
							q.add(new int[] { list.get(ii)[1], x[1] + 1 });
							// System.out.println("\t" + list.get(ii)[1]);
							visit[list.get(ii)[1]] = true;
						}
					if (x[0] == list.get(ii)[1])
						if (!visit[list.get(ii)[0]]) {
							q.add(new int[] { list.get(ii)[0], x[1] + 1 });
							// System.out.println("\t" + list.get(ii)[0]);
							visit[list.get(ii)[0]] = true;
						}
				}
			} // end of while
		} // end of solve
		//System.out.println(Arrays.toString(point));
		int min = Integer.MAX_VALUE;
		for (int ii = 1; ii <= N; ii++)
			min = (min > point[ii]) ? point[ii] : min;
		int cnt = 0;
		for (int ii = 1; ii <= N; ii++) {
			if (point[ii] == min)
				cnt++;
		}
		System.out.println(min + " " + cnt);
		for (int ii = 1; ii <= N; ii++) {
			if (point[ii] == min)
				System.out.print(ii + " ");
		}
		System.out.println();
		
		br.close();
	}// end of main

}
