package search;

import java.io.*;
import java.util.*;

public class BJ_1189 {

    static int R,C,K;
    static char arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int result=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new char[R][C];
        visited=new boolean[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j);
            }
        }

        dfs(R-1,0,0,C-1,1);
        System.out.println(result);

    }

    public static void dfs(int startR, int startC, int endR, int endC, int dist){

        if(startR==endR && startC==endC){
            if(dist==K) result++;
            return;
        }

        visited[startR][startC]=true;

        for(int i=0;i<4;i++){
            int nr=startR+dr[i];
            int nc=startC+dc[i];

            if(nr>=0 && nc>=0 && nr<R && nc<C){
                if(!visited[nr][nc] && arr[nr][nc]=='.'){
                    visited[nr][nc]=true;
                    dfs(nr,nc,endR,endC,dist+1);
                    visited[nr][nc]=false;
                }
            }
        }
    }
}
