package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_2606 {

    static int N,M;
    static int com[][];
    static boolean visited[];
    static int cnt=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine()); // 컴퓨터의 수
        M=Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수
        com=new int[N+1][N+1];
        visited=new boolean[N+1];

        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            com[r][c]=com[c][r]=1;
        }

        DFS(1);
        System.out.println(cnt);
    }

    public static void DFS(int start){

        visited[start]=true;

        for(int i=1;i<=N;i++){
            if(com[start][i]==1 && !visited[i]){
                DFS(i);
                cnt++;
            }
        }

    }
}
