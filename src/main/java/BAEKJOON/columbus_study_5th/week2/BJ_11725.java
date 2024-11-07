package BAEKJOON.columbus_study_5th.week2;
import java.io.*;
import java.util.*;

public class BJ_11725 {

    static int N;
    static ArrayList<Integer> list[];
    static boolean visited[];
    static int parents[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        list=new ArrayList[N+1];
        visited=new boolean[N+1];
        parents=new int[N+1];
        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        for(int i=2;i<=N;i++){
            System.out.println(parents[i]);
        }

    }

    public static void dfs(int parent){

        visited[parent]=true;

        for(int i:list[parent]){
            if(!visited[i]){
                parents[i]=parent;
                dfs(i);
            }
        }
    }
}
