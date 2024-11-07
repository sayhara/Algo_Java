package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_2667 {

    static int N;
    static int arr[][];
    static boolean visited[][];
    static int cnt=0;
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static ArrayList<Integer> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=Integer.parseInt(s.charAt(j)+"");
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==1 && visited[i][j]==false){
                    DFS(i,j);
                    list.add(cnt);
                    cnt=0;
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    public static void DFS(int r, int c){

        visited[r][c]=true;
        cnt++;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<N){
                if(arr[nr][nc]==1 && !visited[nr][nc]){
                    DFS(nr,nc);
                }
            }
        }
    }
}
