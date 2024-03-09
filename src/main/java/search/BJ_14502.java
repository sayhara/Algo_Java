package search;
import java.io.*;
import java.util.*;

public class BJ_14502 {

    static int N,M;
    static int arr[][];
    static int new_arr[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int max=Integer.MIN_VALUE;
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        init();
        wall(0);

        System.out.println(max);
    }

    public static void wall(int cnt){

        if(cnt==3){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(new_arr[i][j]==2){
                        dfs(i,j);
                    }
                }
            }
            check();
            init();
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(new_arr[i][j]==0){
                    new_arr[i][j]=1;
                    wall(cnt+1);
                    new_arr[i][j]=0;
                }
            }
        }
    }

    public static void dfs(int r, int c){

        new_arr[r][c]=2;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<M){
                if(new_arr[nr][nc]==0){
                    dfs(nr,nc);
                }
            }
        }
    }

    public static void check(){
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(new_arr[i][j]==0) count++;
            }
        }
        max=Math.max(max,count);
    }

    public static void init(){

        new_arr=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                new_arr[i][j]=arr[i][j];
            }
        }
    }
}
