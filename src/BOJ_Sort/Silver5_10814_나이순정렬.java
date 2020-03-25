package BOJ_Sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ_Sort
 * @FileName : Silver5_10814_나이순정렬.java
 *
 * @Date : 2020. 4. 2.
 * @작성자 : 한기연
 * @메모리 : 147412 kb
 * @실행시간 : 1832 ms
 *
 * @Blog : __
 **/
public class Silver5_10814_나이순정렬 {
	static class User implements Comparable<User> {
		int age;
		String name;

		public User(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(User o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		User[] users = new User[N];
		for (int i = 0; i < N; i++) {
			users[i] = new User(sc.nextInt(), sc.next());
		}

		Arrays.sort(users);

		for (User user : users) {
			System.out.println(user);
		}
	}
}