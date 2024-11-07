package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_4963 {

    static int w,h;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={-1,-1,-1,0,0,1,1,1};
    static int dc[]={-1,0,1,1,-1,0,-1,1};
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            w=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            arr=new int[h][w];
            visited=new boolean[h][w];
            int count=0;

            for(int i=0;i<h;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(arr[i][j]==1 && !visited[i][j]){
                        DFS(i,j);
                        count++;
                    }
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void DFS(int r, int c){

        visited[r][c]=true;

        for(int i=0;i<8;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<h && nc<w){
                if(arr[nr][nc]==1 && !visited[nr][nc]){
                    DFS(nr,nc);
                }
            }
        }
    }
}
