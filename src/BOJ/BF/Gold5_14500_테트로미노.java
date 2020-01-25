package BOJ.BF;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Algorithm_java
 * @PackageName: BOJ.BF
 * @FileName : Main.java
 *
 * @Date : 2020. 1. 25.
 * @작성자 : 한기연
 * @메모리 : 158104 kb
 * @실행시간 : 936 ms
 **/

public class Gold5_14500_테트로미노 {
	static int[][] map;
	static int[][][] block = { 
			{
				{ 1, 1, 1, 1 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }
			},{
				{ 1, 0, 0, 0 }, 
				{ 1, 0, 0, 0 }, 
				{ 1, 0, 0, 0 }, 
				{ 1, 0, 0, 0 }
			},{
				{ 1, 1, 0, 0 }, 
				{ 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }
			},{
				{ 1, 0, 0, 0 },
				{ 1, 0, 0, 0 },
				{ 1, 1, 0, 0 },
				{ 0, 0, 0, 0 }
			}, {
				{ 1, 1, 1, 0 }, 
				{ 1, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }
			},{ 
				{ 1, 1, 0, 0 }, 
				{ 0, 1, 0, 0 }, 
				{ 0, 1, 0, 0 }, 
				{ 0, 0, 0, 0 }
			},{ 
				{ 0, 0, 1, 0 },
				{ 1, 1, 1, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 }
			},{ 
				{ 1, 1, 0, 0 },
				{ 1, 0, 0, 0 },
				{ 1, 0, 0, 0 },
				{ 0, 0, 0, 0 }
			},{
				{ 1, 0, 0, 0 },
				{ 1, 1, 1, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 } 
			},{ 
				{ 0, 1, 0, 0 },
				{ 0, 1, 0, 0 },
				{ 1, 1, 0, 0 },
				{ 0, 0, 0, 0 }
			},{ 
				{ 1, 1, 1, 0 },
				{ 0, 0, 1, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 }
			},{ 
				{ 1, 0, 0, 0 },
				{ 1, 1, 0, 0 },
				{ 0, 1, 0, 0 },
				{ 0, 0, 0, 0 }
			},{ 
				{ 0, 1, 1, 0 },
				{ 1, 1, 0, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 }
			},{ 
				{ 0, 1, 0, 0 },
				{ 1, 1, 0, 0 },
				{ 1, 0, 0, 0 },
				{ 0, 0, 0, 0 }
			},{ 
				{ 1, 1, 0, 0 },
				{ 0, 1, 1, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 }
			},{
				{ 1, 0, 0, 0 },
				{ 1, 1, 0, 0 },
				{ 1, 0, 0, 0 },
				{ 0, 0, 0, 0 }
			},{
				{ 1, 1, 1, 0 },
				{ 0, 1, 0, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 }
			},{ 
				{ 0, 1, 0, 0 },
				{ 1, 1, 0, 0 },
				{ 0, 1, 0, 0 },
				{ 0, 0, 0, 0 }
			},{ 
				{ 0, 1, 0, 0 },
				{ 1, 1, 1, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 },
			}
	};
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();

		map = new int[N + 3][M + 3];
		for (int i = 0; i < N + 3; i++) {
			Arrays.fill(map[i], -100000);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 19; k++) {
					int ret = solve(i, j, k);
					if (max < ret) {
						max = ret;
					}
				}
			}
		}
		System.out.println(max);
	}

	private static int solve(int i, int j, int k) {
		int ret = 0;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				ret += block[k][row][col] * map[i + row][j + col];
			}
		}
		return ret;
	}
}