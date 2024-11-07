package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_2468 {

    static int N;
    static int arr[][];
    static int height=0;
    static int cnt=0;
    static int max=0;
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]>height) height=arr[i][j];
            }
        }

        while(height>=0){

            cnt=0;
            visited=new boolean[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j]>height && !visited[i][j]){ // 물에 잠기지 않는 경우
                        DFS(i,j);
                        cnt++;
                    }
                }
            }
            max=Math.max(max,cnt);
            height--;
        }

        System.out.println(max);

    }

    public static void DFS(int r, int c){

        visited[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<N){
                if(arr[nr][nc]>height && !visited[nr][nc]){
                    DFS(nr,nc);
                }
            }
        }
    }
}
