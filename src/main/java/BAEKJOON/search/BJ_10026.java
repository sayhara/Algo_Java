package BAEKJOON.search;
import java.io.*;

public class BJ_10026 {

    static int N;
    static char arr[][];
    static boolean visited[][];
    static int cnt1=0;
    static int cnt2=0;
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new char[N][N];


        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j);
            }
        }

        visited=new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    DFS(i,j,arr[i][j]);
                    cnt1++;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]=='R'){
                    arr[i][j]='G';
                }
            }
        }

        visited=new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    DFS(i,j,arr[i][j]);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1+" "+cnt2);
    }

    public static void DFS(int r, int c, char val){

        visited[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<N){
                if(arr[nr][nc]==val && !visited[nr][nc]){
                    DFS(nr,nc,val);
                }
            }
        }
    }
}
