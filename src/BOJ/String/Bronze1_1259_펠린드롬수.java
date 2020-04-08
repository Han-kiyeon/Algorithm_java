package BOJ.String;
import java.util.Scanner;

public class Bronze1_1259_펠린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			String X = sc.next();
			if (X.equals("0"))
				break;

			boolean flag = true;
			for (int i = 0; i < X.length() / 2 + 1 && flag; i++) {
				if (X.charAt(i) != X.charAt(X.length() - i - 1))
					flag = false;
			}
			
			System.out.println(flag ? "yes" : "no");

		} // end of TC
	}
}
