import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int E, S, M;
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();

		int year = 1;

		while (true) {
			if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19== 0)
				break;
			year++;
		}

		System.out.println(year);
	}
}