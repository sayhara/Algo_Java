package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_1926 {

    static int n,m;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static ArrayList<Integer> list=new ArrayList<>();
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && arr[i][j]==1){
                    dfs(i,j);
                    list.add(count);
                    count=0;
                }
            }
        }

        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list.size());
        System.out.println(list.size()==0?0:list.get(0));

    }

    public static void dfs(int r, int c){

        visited[r][c]=true;
        count++;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<n && nc<m){
                if(!visited[nr][nc] && arr[nr][nc]==1){
                    dfs(nr,nc);
                }
            }
        }
    }
}
