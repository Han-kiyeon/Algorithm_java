package com.d2;

import java.io.*;
import java.util.*;

public class Solution_D2_1859_백만장자프로젝트 {
	 public static void main(String[] args) throws Exception{
			System.setIn(new FileInputStream("res/D2_1859_백만장자프로젝트.txt"));
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st = null;
       StringBuilder sb = new StringBuilder();
        
       int T = Integer.parseInt(br.readLine());
       for(int tc=1; tc<=T; tc++) {
           int N = Integer.parseInt(br.readLine());
            
           st = new StringTokenizer(br.readLine());
           int[] price = new int[N];
           for(int i = 0; i < N; i++) price[i] = Integer.parseInt(st.nextToken());
            
           long total = 0;
           int max = 0;
           for(int i = N-1; i >= 0; i--) {
               int p = price[i];
               if(p > max) max = p;
               else total += max-p;
           }
           sb.append("#" + tc + " " + total + "\n");
       }
       bw.write(sb.toString());
       bw.flush();
   }
}
