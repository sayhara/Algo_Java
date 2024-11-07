package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_2178 {

    static int N,M;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(s.charAt(j)+"");
            }
        }

        BFS(0,0);

        System.out.println(arr[N-1][M-1]);
    }

    public static void BFS(int r, int c){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c]=true;

        while(!q.isEmpty()){

            int[] now = q.poll();
            int br=now[0];
            int bc=now[1];

            for(int i=0;i<4;i++){
                int nr=br+dr[i];
                int nc=bc+dc[i];

                if(nr>=0 && nc>=0 && nr<N && nc<M){
                    if(arr[nr][nc]!=0 && !visited[nr][nc]){
                        visited[nr][nc]=true;
                        arr[nr][nc]=arr[br][bc]+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
    }
}
