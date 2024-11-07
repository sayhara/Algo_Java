package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_1260 {

    static int N,M,V;
    static int graph[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 정점 개수
        M=Integer.parseInt(st.nextToken()); // 간선 개수
        V=Integer.parseInt(st.nextToken()); // 시작 정점
        graph=new int[N+1][N+1];


        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            graph[u][v]=graph[v][u]=1;
        }

        visited=new boolean[N+1];
        DFS(V);

        System.out.println();
        visited=new boolean[N+1];
        BFS(V);

    }

    public static void DFS(int start){

        visited[start]=true;
        System.out.print(start+" ");

        for(int i=1;i<=N;i++){
            if(graph[start][i]==1 && !visited[i]){
                DFS(i);
            }
        }
    }

    public static void BFS(int start){

        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;

        while(!q.isEmpty()){
            int now=q.poll();
            System.out.print(now+" ");

            for(int i=1;i<=N;i++){
                if(graph[now][i]==1 && !visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}
