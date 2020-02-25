package com.d4;

import java.io.*;
import java.util.*;

public class Solution_D4_3289_서로소집합_서울8반_한기연2 {
    public static int[] node;
    
    public static int findParent(int a) {
        if(node[a]==a) return a;
        return node[a] = findParent(node[a]);
    }
    
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/D4_3289_서로소집합.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            StringBuilder sb = new StringBuilder();
            
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            node = new int[N+1];
            for(int i = 1; i <= N; i++) node[i] = i; // Make-Set
            
            sb.append("#" + tc + " ");
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if(type==0) {
                    // Find-Set & Union //
                    a = findParent(a);
                    b = findParent(b);
                    if(a!=b) {
                        if(a<b) node[b] = a;
                        else node[a] = b;
                    }
                }
                else {
                    if(findParent(a)==findParent(b)) sb.append("1");
                    else sb.append("0");
                }
            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
    }
}
