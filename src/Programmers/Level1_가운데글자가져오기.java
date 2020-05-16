package Programmers;

<<<<<<< HEAD
=======
import java.util.Date;

>>>>>>> 74aeb10d8c5ed5694a5ba2af50ab08edb235207e
public class Level1_가운데글자가져오기 {
	public static void main(String[] args) {
		System.out.println(solution("abcde"));// "c";
		System.out.println(solution("qwer"));// "we";
	}

	public static String solution(String s) {
		if (s.length() % 2 == 1)
			return "" + s.charAt(s.length() / 2);
		else
			return "" + s.charAt(s.length() / 2 - 1) + s.charAt(s.length() / 2);
	}
}