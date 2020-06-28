import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();

		LinkedList<Character> list = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		ListIterator<Character> iter = list.listIterator(list.size());
		int M = Integer.parseInt(br.readLine());

		for (int k = 0; k < M; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
				case "L":
					if (iter.hasPrevious())
						iter.previous();
					break;
				case "D":
					if (iter.hasNext())
						iter.next();
					break;
				case "B":
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				case "P":
					iter.add(st.nextToken().charAt(0));
					break;
			}
		}

		for (Character c : list) {
			bw.write(c);
		}
		bw.flush();
	}
}