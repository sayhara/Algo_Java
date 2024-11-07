package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_14502 {

    static int N,M;
    static int arr[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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

        wall(0);
        System.out.println(max);
    }

    public static void wall(int cnt){

        if(cnt==3){
            bfs();
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    wall(cnt+1);
                    arr[i][j]=0;
                }
            }
        }
    }

    public static void bfs(){

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        int copy_arr[][]=new int[N][M];

        for(int i=0;i<N;i++){
            copy_arr[i]=arr[i].clone();
        }

        while(!q.isEmpty()) {

            int now[]=q.poll();
            int br=now[0];
            int bc=now[1];

            for (int i = 0; i < 4; i++) {
                int nr = br + dr[i];
                int nc = bc + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    if (copy_arr[nr][nc] == 0) {
                        copy_arr[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy_arr[i][j]==0) count++;
            }
        }
        max=Math.max(max,count);
    }

}
