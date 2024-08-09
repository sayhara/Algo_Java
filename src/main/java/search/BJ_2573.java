package search;

import java.io.*;
import java.util.*;

public class BJ_2573 {

    static int N,M;
    static int arr[][];
    static int result[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int time=0;
    static int All_count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        while(true){

            boolean chk=false;
            result=new int[N][M];
            visited=new boolean[N][M];
            All_count=0;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j]!=0 && !visited[i][j]){
                        chk=true;
                        check(i,j);
                        All_count++;
                    }
                }
            }

            if(!chk){
                System.out.println(0);
                return;
            }

            if(All_count>=2){
                System.out.println(time);
                return;
            }

            // melting 작업
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j]!=0){
                        melt(i,j);
                    }
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    arr[i][j]=arr[i][j]-result[i][j]<0?0:arr[i][j]-result[i][j];
                }
            }
            time++;
        }
    }

    public static void check(int r, int c){

        visited[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<M){
                if(arr[nr][nc]!=0 && !visited[nr][nc]){
                    check(nr,nc);
                }
            }
        }
    }

    public static void melt(int r, int c){

        int cnt=0;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<M && arr[nr][nc]==0){
                cnt++;
            }
        }
        result[r][c]=cnt;
    }
}