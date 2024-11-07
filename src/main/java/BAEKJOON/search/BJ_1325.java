package BAEKJOON.search;

import java.io.*;
import java.util.*;

public class BJ_1325 {

    static int N,M;
    static ArrayList<Integer> list[];
    static boolean visited[];
    static int result[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        list=new ArrayList[N+1];
        result=new int[N+1];
        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            list[A].add(B);
        }

        for(int i=1;i<=N;i++){
            visited=new boolean[N+1];
            bfs(i);
        }

        int max=0;
        for(int i=1;i<=N;i++){
            max=Math.max(max,result[i]);
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<=N;i++){
            if(max==result[i]){
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int start){

        visited[start]=true;

        for(int num:list[start]){
            if(!visited[num]){
                result[num]++;
                dfs(num);
            }
        }
    }

    public static void bfs(int start){

        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;

        while(!q.isEmpty()){

            int now=q.poll();

            for(int num:list[now]){
                if(!visited[num]){
                    result[num]++;
                    visited[num]=true;
                    q.add(num);
                }
            }
        }
    }
}
