package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_1219_길찾기_한기연_ver3 {
	 public static int V = 100;
	    public static int T;
	    public static int N;
	    public static int[][] graph;
	    public static boolean[] visit;
	    
	    public static void main(String[] args) throws Exception {
	        System.setIn(new FileInputStream("res/1219_D4_길찾기.txt"));
	        Scanner sc = new Scanner(System.in);
	        for (int tc = 1; tc <= 10; tc++) {
	            sc.nextInt();
	            N = sc.nextInt();
	            graph = new int[V][V];
	            
	            
	            for (int i = 0; i < N; i++) {
	                int v1 = sc.nextInt();
	                int v2 = sc.nextInt();
	                graph[v1][v2] = 1;
	            }
	            visit = new boolean[V];
	        
	            System.out.println("#" + tc + " " + dfsr(0));
	        }
	        sc.close();
	    }
	    // 주로 이 코드를 이용해서 사용함
	    public static int dfsr(int node) {
	        visit[node] = true;
	        if (node == 99)
	            return 1;
	        
	        for (int next = 0; next < V; next++) { // 0 2 4 5 6 3 1
	            if (visit[next] == false && graph[node][next] == 1) {
	                if(dfsr(next)==1) return 1;
	            }
	        }
	        return 0;
	    }
	}

