package samsung;
import java.io.*;
import java.util.*;

public class BJ_14500 {

    static int N,M;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int max=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 세로
        M=Integer.parseInt(st.nextToken()); // 가로
        arr=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j]=true;
                dfs(i,j,1,arr[i][j]);
                visited[i][j]=false;
            }
        }

        System.out.println(max);

    }

    public static void dfs(int r, int c, int cnt, int sum){

        if(cnt==4){
            max=Math.max(max,sum);
            return;
        }

        for(int i=0;i<4;i++){

            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc]) continue;

            if(cnt==2){
                visited[nr][nc]=true;
                dfs(r,c,cnt+1,sum+arr[nr][nc]);
                visited[nr][nc]=false;
            }

            visited[nr][nc]=true;
            dfs(nr,nc,cnt+1,sum+arr[nr][nc]);
            visited[nr][nc]=false;

        }
    }

}
