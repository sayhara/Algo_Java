package BAEKJOON.columbus_study_5th.week2;
import java.io.*;
import java.util.*;

public class BJ_1012 {

    static int N,M,K;
    static int arr[][];
    static boolean visited[][];
    static int count;
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(T-->0){

            st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken()); // 가로길이
            N=Integer.parseInt(st.nextToken()); // 세로길이
            K=Integer.parseInt(st.nextToken()); // 위치의 개수
            arr=new int[N][M];
            visited=new boolean[N][M];
            count=0;

            for(int i=0;i<K;i++){
                st=new StringTokenizer(br.readLine());
                int X=Integer.parseInt(st.nextToken());
                int Y=Integer.parseInt(st.nextToken());
                arr[Y][X]=1; // 배추의 위치
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && arr[i][j]==1){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int r, int c){

        visited[r][c]=true;

        for(int i=0;i<4;i++){ // 상하좌우 탐색
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<M){
                if(!visited[nr][nc] && arr[nr][nc]==1){
                    dfs(nr,nc);
                }
            }
        }
    }
}
