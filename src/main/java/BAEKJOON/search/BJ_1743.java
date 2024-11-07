package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_1743 {

    static int N,M,K;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int cnt=0;
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr[r-1][c-1]=1;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    DFS(i,j);
                    max=Math.max(max,cnt);
                    cnt=0;
                }
            }
        }

        System.out.println(max);

    }

    public static void DFS(int r, int c){

        visited[r][c]=true;
        cnt++;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<M){
                if(arr[nr][nc]==1 && !visited[nr][nc]){
                    DFS(nr,nc);
                }
            }
        }
    }
}
