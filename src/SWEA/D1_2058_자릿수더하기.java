package SWEA;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : D1_2058_자릿수더하기.java
 *
 * @Date : 2019. 8. 21.
 * @작성자 : 한기연
 * @메모리 : 16,444 kb
 * @실행시간 : 155 ms
 *
 * @Blog : __
 **/
public class D1_2058_자릿수더하기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D1_2058_자릿수더하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int sum = 0;
		for(int i = 0;i<str.length(); i++)
			sum +=str.charAt(i)-'0';
		System.out.println(sum);
		br.close();
	}
}
