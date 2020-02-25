import java.util.*;

public class Main_백준_14891_톱니바퀴_서울8반_한기연 {
	static int[][] wheels;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		wheels = new int[5][8];
		for (int i = 1; i <= 4; i++) {
			String str = sc.next();
			for (int j = 0; j < 8; j++) {
				if (str.charAt(j) == '1')
					wheels[i][j] = 1; // S극
				else
					wheels[i][j] = 0; // N극
			}
		}

		int K = sc.nextInt(); // 회전 횟수 K;
		for (int i = 0; i < K; i++) {
			// 톱니바퀴 번호, 방향(1:시계 -1:반시계)
			isspin(sc.nextInt(), sc.nextInt());
		}

		System.out.println( 1 * wheels[1][0] 
						      + 2 * wheels[2][0] 
								+ 4 * wheels[3][0] 
								+ 8 * wheels[4][0]);

		sc.close();
	}

	//좌우에 톱니를 회전할 수 있는지 확인.
	private static void isspin(int num, int dir) { 
		//회전이 가능한 톱니번호와 뱡향을 저장
		ArrayList<int[]> list = new ArrayList<>(); 
		
		list.add(new int[] { num, dir });

		int flag = dir;
		int temp = num;
		int right = wheels[num][2]; //현재 바퀴의 오른쪽값.
		while (temp + 1 <=4) { // 오른쪽에 바퀴가 존재한다면
			if (right != wheels[temp + 1][6]) {//회전이 가능한지 
				temp++;
				flag *= -1;
				right = wheels[temp][2]; 
				list.add(new int[] { temp, flag });
			}
			else
				break;
		}

		flag = dir;
		temp = num;
		int left = wheels[num][6]; //현재 바퀴의 왼쪽값.
		while (temp - 1 >=1) { // 왼쪽에 바퀴가 존재한다면
			if (left != wheels[temp - 1][2]) { //회전이 가능한지
				temp--;
				flag *= -1; //반대방향
				left = wheels[temp][6]; 
				list.add(new int[] { temp, flag });
			}
			else
				break;
		}
		for (int i = 0; i < list.size(); i++) {
			spin(list.get(i)[0], list.get(i)[1]);
		}
	}

	private static void spin(int num, int dir) {
		int[] temp = wheels[num].clone(); // 복사

		if (dir == 1) {// 시계방향이면 >> 오른쪽으로 한칸씩
			for (int i = 1; i < 8; i++) {
				wheels[num][i] = temp[i - 1];
			}
			wheels[num][0] = temp[7];
		} else {// 반시계방향이면 >> 왼쪽으로 한칸씩
			for (int i = 1; i < 8; i++) {
				wheels[num][i - 1] = temp[i];
			}
			wheels[num][7] = temp[0];
		}
	}
}
