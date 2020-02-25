package com.d4;

import java.util.*;
import java.io.*;
class mydata{
   int start;
   int end;
   mydata(int start,int end){
       this.start=start;
       this.end=end;
   }
}
public class Solution_D4_4408_자기방으로돌아가기_서울8반_김도하 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D4_4408_자기방으로돌아가기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(br.readLine());
      for(int tc=1;tc<=T;tc++) {
          int answer=0;
          int n=Integer.parseInt(br.readLine());
          StringTokenizer st;
          ArrayList<mydata>list=new ArrayList<>();
          for(int i=0;i<n;i++) {
              st=new StringTokenizer(br.readLine());
              int num1=Integer.parseInt(st.nextToken());
              int num2=Integer.parseInt(st.nextToken());
              int min=num1<num2?num1:num2;
              int max=num1>num2?num1:num2;
              if(min%2==0) {
                  if(max%2==0) list.add(new mydata(min/2,max/2));
                  else list.add(new mydata(min/2,max/2+1));
              }
              else{
                  if(max%2==0) list.add(new mydata(min/2+1,max/2));
                  else list.add(new mydata(min/2+1,max/2+1));
              }
          }
          Collections.sort(list,new Comparator<mydata>() {
              public int compare(mydata arg0, mydata arg1) {
                  if(arg0.start==arg1.start) return arg0.end-arg1.end;
                  else return arg0.end-arg1.end;
              }
          });
          boolean visit[]=new boolean[n];
          int pivot=0;
          for(int i=0;i<list.size();i++) {
              if(!visit[i]) {
                  visit[i]=true;
                  answer++;
                  pivot=i;
                  for(int j=0;j<list.size();j++) {
                      if(i!=j&&!visit[j]&&list.get(j).start>list.get(pivot).end) {
                          visit[j]=true;
                          pivot=j;
                      }
                  }
              }
          }
          System.out.println("#"+tc+" "+answer);
      }
  }
}



