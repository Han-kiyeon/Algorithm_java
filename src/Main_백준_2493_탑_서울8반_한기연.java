import java.io.*;

public class Main_백준_2493_탑_서울8반_한기연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = (Integer.parseInt(br.readLine()));
		String line = br.readLine();
		String[] sa = line.split(" ");
		int[] arr = new int[N];
		int[] height = new int[N];
		
		for (int tc = 0; tc < N; tc++) 
			arr[tc] = Integer.parseInt(sa[tc]);
		

		for (int i = N - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					height[i] = j + 1;
					break;
				}
			}
		}
		
		for (int x : height)
			System.out.print(x + " ");
	}
}




