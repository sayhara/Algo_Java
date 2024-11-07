package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_2210 {

    static int arr[][]=new int[5][5];
    static Set<String> set=new HashSet<>();
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<5;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                dfs(i,j,0,Integer.toString(arr[i][j]));
            }
        }

        System.out.println(set.size());

    }

    public static void dfs(int r, int c, int cnt, String result){

        if(cnt==5){
            set.add(result);
            return;
        }


        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr<0 || nc<0 || nr>=5 || nc>=5) continue;
            dfs(nr,nc,cnt+1,result+arr[nr][nc]);
        }
    }
}
