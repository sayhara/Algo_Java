package BAEKJOON.search;
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

        for(int i=1;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[r].add(c);
            list[c].add(r);
        }

        dfs(1);

        for(int i=2;i<=N;i++){
            System.out.println(parents[i]);
        }

    }

    public static void dfs(int parent){

        visited[parent]=true;

        for(int num:list[parent]){
            if(!visited[num]){
                parents[num]=parent;
                dfs(num);
            }
        }
    }
}
