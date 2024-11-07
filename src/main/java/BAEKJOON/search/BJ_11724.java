package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_11724 {

    static int N,M;
    static int graph[][];
    static boolean visited[];
    static int cnt=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 정점의 개수
        M=Integer.parseInt(st.nextToken()); // 간선의 개수
        graph=new int[N+1][N+1];
        visited=new boolean[N+1];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            graph[u][v]=graph[v][u]=1;
        }

        for(int i=1;i<=N;i++){
            if(!visited[i]){
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void DFS(int idx){

        visited[idx]=true;

        for(int i=1;i<=N;i++){
            if(graph[idx][i]==1 && !visited[i]){
                DFS(i);
            }
        }
    }
}
