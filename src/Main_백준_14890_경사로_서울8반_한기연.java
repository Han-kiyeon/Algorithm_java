import java.util.ArrayList;
import java.util.Scanner;

public class Main_백준_14890_경사로_서울8반_한기연 {

	static int N, L;
	static int[][] map;
	static boolean[][] visitRow, visitCol;
	
	static ArrayList<int[]> v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}	
		int ans = 0;
		int j = 0;// 끝에 도착시 j로 체크
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (j = 0; j < N-1; j++) { //가로: 좌->우
				     if(map[i][j]  ==map[i][j+1])            cnt++; //평지
				else if(map[i][j]+1==map[i][j+1] && cnt>= L) cnt=1; //오르막
				else if(map[i][j]-1==map[i][j+1] && cnt>= 0) cnt=-L+1; //내리막
				else break;
			}
			if(j==N-1 && cnt>= 0) ans++; //끝에 도착
			
			cnt=1;
			for (j = 0; j < N-1; j++) { //세로: 상->하
				     if(map[j][i]  ==map[j+1][i])            cnt++; //평지
				else if(map[j][i]+1==map[j+1][i] && cnt>= L) cnt=1; //오르막
				else if(map[j][i]-1==map[j+1][i] && cnt>= 0) cnt=-L+1; //내리막
				else break;
			}
			if(j==N-1 && cnt>= 0) ans++; //끝에 도착
			
		}

		System.out.println(ans);
	}
}
