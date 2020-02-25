package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2543_타일채우기_서울8반_한기연2 {
	static int[][] map;
	public static void tile(int sx, int sy, int ex, int ey, int hx, int hy, int hc) {
		int mx = (sx + ex) / 2;
		int my = (sy + ey) / 2;
		
		if(sx == ex) {
			map[sx][sy]= hc;
			return;
		}
		if(sx <= hx && hx <= mx && sy <= hy && hy <= my) {
			tile(sx, sy, mx, my, hx, hy ,hc);
			tile(sx, my + 1, mx, ey, mx, my + 1 , 1);
			tile(mx + 1, sy , ex, my, mx + 1, my, 1);
			tile(mx + 1, my + 1, ex, ey, mx + 1, my + 1 , 1);
		}
		else if(sx <= hx && hx <= mx && my + 1 <= hy && hy <= ey) {
			tile(sx, sy, mx, my, mx, my ,2 );
			tile(sx, my + 1, mx, ey, hx, hy , hc);
			tile(mx + 1, sy , ex, my, mx + 1, my, 2);
			tile(mx + 1, my + 1, ex, ey, mx + 1, my + 1 , 2);
		}
		else if(mx + 1 <= hx && hx <= ex && sy <= hy && hy <= my) {
			tile(sx, sy, mx, my, mx, my ,3);
			tile(sx, my + 1, mx, ey, mx, my + 1 , 3);
			tile(mx + 1, sy , ex, my, hx, hy, hc);
			tile(mx + 1, my + 1, ex, ey, mx + 1, my + 1 , 3);
		}
		else if(mx + 1 <= hx && hx <= ex && my + 1 <= hy && hy <= ey) {
			tile(sx, sy, mx, my, mx, my ,4);
			tile(sx, my + 1, mx, ey, mx, my + 1 , 4);
			tile(mx + 1, sy , ex, my, mx + 1, my, 4);
			tile(mx + 1, my + 1, ex, ey, hx, hy , hc);
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 맵 크기
		
		map = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()); // 하수구 x
		int y = Integer.parseInt(st.nextToken()); // 하수구 y
		
		// 왼쪽위 초기값

		tile(0,0, N-1, N-1, x, y, 0);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
