package search;
import java.io.*;
import java.util.*;

public class BJ_7576 {

    static int M,N;
    static int arr[][];
    static Queue<int[]> q=new LinkedList<>();
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken()); // 가로
        N=Integer.parseInt(st.nextToken()); // 세로
        arr=new int[N][M];
        // 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 들어있지 않은 경우

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) q.add(new int[]{i,j});
            }
        }

        BFS();

        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                max=Math.max(max,arr[i][j]);
            }
        }

        if(max>1){
            System.out.println(max-1);
        } else {
            System.out.println(0);
        }

    }

    public static void BFS(){

        while(!q.isEmpty()){

            int[] now=q.poll();
            int br=now[0];
            int bc=now[1];

            for(int i=0;i<4;i++){
                int nr=br+dr[i];
                int nc=bc+dc[i];

                if(nr>=0 && nc>=0 && nr<N && nc<M){
                    if(arr[nr][nc]==0){
                        arr[nr][nc]=arr[br][bc]+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
    }
}
