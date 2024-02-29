package search;
import java.io.*;
import java.util.*;

public class BJ_2583 {

    static int M,N,K;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int count=0;
    static ArrayList<Integer> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[M][N];
        visited=new boolean[M][N];

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for(int r=M-y2;r<M-y1;r++){
                for(int c=x1;c<x2;c++){
                    arr[r][c]=1;
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==0 && !visited[i][j]){
                    count=0;
                    DFS(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }

    public static void DFS(int r, int c){

        visited[r][c]=true;
        count++;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<M && nc<N){
                if(arr[nr][nc]==0 && !visited[nr][nc]){
                    DFS(nr,nc);
                }
            }
        }
    }
}
