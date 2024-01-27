package search;
import java.io.*;
import java.util.*;

public class BJ_1012 {

    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int M,N,K;
    static int arr[][];
    static boolean visited[][];
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        while(T-->0){

            int cnt=0;

            StringTokenizer st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken()); // 가로
            N=Integer.parseInt(st.nextToken()); // 세로
            K=Integer.parseInt(st.nextToken()); // 개수
            arr=new int[N][M];
            visited=new boolean[N][M];

            for(int i=0;i<K;i++){
                st=new StringTokenizer(br.readLine());
                int X=Integer.parseInt(st.nextToken()); // 가로
                int Y=Integer.parseInt(st.nextToken()); // 세로
                arr[Y][X]=1;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && arr[i][j]==1){
                        DFS(i,j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt+"\n");
        }

        System.out.println(sb.toString());
    }

    public static void DFS(int r, int c){

        visited[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<M){
                if(!visited[nr][nc] && arr[nr][nc]==1){
                    DFS(nr,nc);
                }
            }
        }
    }
}
