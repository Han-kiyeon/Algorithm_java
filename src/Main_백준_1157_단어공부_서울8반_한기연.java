import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_1157_단어공부_서울8반_한기연 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toUpperCase().toCharArray();
		
		int[] cnt = new int[26];
		
		for (int i = 0; i < arr.length; i++) {
			cnt[arr[i]-'A']++;
		}
		int max = -1;
		int maxIdx = -1;
		for (int i = 0; i < cnt.length; i++) {
			if(max<cnt[i]) {
				max = cnt[i];
				maxIdx = i;
			}
		}
		
		for (int i = 0; i < cnt.length; i++) {
			if(maxIdx!=i) {
				if(max==cnt[i]) {
					System.out.println("?");
					return;
				}			
			}
		}
		
		System.out.println((char)('A'+maxIdx));
	}

}
