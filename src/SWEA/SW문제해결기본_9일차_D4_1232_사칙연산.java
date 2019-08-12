package SWEA;

import java.util.Scanner;
 
/**
 * @Project : Algorithm_java
 * @PackageName: SWEA
 * @FileName : SW문제해결기본_9일차_D4_1232_사칙연산.java
 *
 * @Date : 2019. 8. 12.
 * @작성자 : 한기연
 * @메모리 : 37,476 kb
 * @실행시간 : 204 ms
 *
 * @Blog : __
 **/
public class SW문제해결기본_9일차_D4_1232_사칙연산 {
    static String[][] strArr;
    static int N;
 
    private static int solve(int i) {
        switch(strArr[i][1]) {
        case "+" : return solve(Integer.parseInt(strArr[i][2])) + solve(Integer.parseInt(strArr[i][3]));
        case "-" : return solve(Integer.parseInt(strArr[i][2])) - solve(Integer.parseInt(strArr[i][3])); 
        case "*" : return solve(Integer.parseInt(strArr[i][2])) * solve(Integer.parseInt(strArr[i][3])); 
        case "/" : return solve(Integer.parseInt(strArr[i][2])) / solve(Integer.parseInt(strArr[i][3]));
        }
        return Integer.parseInt(strArr[i][1]);
    }
 
    private static boolean checkOp(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
            return true;
        else
            return false;
    }
 
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/1232_D4_사칙연산.txt"));
        Scanner sc = new Scanner(System.in);
 
        int T = 10; // 10개의 테스트 케이스
 
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); // 정점의 개수
            strArr = new String[N + 1][4];
 
            for (int i = 1; i <= N; i++) {
                strArr[i][0] = sc.next();// 정점번호
                String tmp = sc.next();
                if (checkOp(tmp)) { // 연산자이면
                    strArr[i][1] = tmp; // 배열에 넣고
                    strArr[i][2] = sc.next();// 왼쪽 자식노드 번호
                    strArr[i][3] = sc.next();// 오른쪽 자식 노드 번호
                } else {
                    strArr[i][1] = tmp; // 배열에 넣고
                    strArr[i][2] = null;// 왼쪽 자식노드 번호
                    strArr[i][3] = null;// 오른쪽 자식 노드 번호
                }
            }
             
            System.out.println("#" + tc + " " + solve(1));
        }
        sc.close();
    }
}