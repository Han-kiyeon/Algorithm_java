package BOJ_ETC;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Gold5_2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder(N * 2);
		Stack<int[]> stack = new Stack<>();

		stack.push(new int[] { Integer.parseInt(st.nextToken()), 1 });// 1번 빌딩의 높이 , idx
		sb.append("0 "); // 1번 빌딩은 수신하는 빌딩이 없음

		for (int i = 2; i <= N; i++) {
			int value = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				int stackValue = stack.peek()[0];
				int stackIndex = stack.peek()[1];
				if (value < stackValue) {// 현재 빌딩의 높이가 현재 최대 높이 빌딩의 높이보다 작은경우
					sb.append(stackIndex).append(" "); // 최대 높이의 빌딩 번호(수신하는 빌딩)
					break;
				} else { // 현재 빌딩의 높이가 top보다 큰경우
					stack.pop();
				}
			}
			if (stack.isEmpty()) { // 비어있을경우
				sb.append("0 ");
			}
			stack.push(new int[] { value, i });
		}

		bw.write(sb+"\n");
		bw.flush();
	}

}