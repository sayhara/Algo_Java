package search;
import java.io.*;
import java.util.*;

public class BJ_7569 {

    static int M,N,H;
    static int arr[][][];
    static int dr[]={0,0,1,-1,0,0};
    static int dc[]={0,0,0,0,1,-1};
    static int dh[]={1,-1,0,0,0,0};
    static int max=Integer.MIN_VALUE;
    static Queue<Tomato> q=new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken()); // 가로
        N=Integer.parseInt(st.nextToken()); // 세로
        H=Integer.parseInt(st.nextToken()); // 높이
        arr=new int[H][N][M];

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    arr[i][j][k]=Integer.parseInt(st.nextToken());
                    if(arr[i][j][k]==1) q.add(new Tomato(i,j,k)); // 동시 발생 -> 한번에 적재 후 탐색
                }
            }
        }

        BFS();

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(arr[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    max=Math.max(max,arr[i][j][k]);
                }
            }
        }
        if(max==1){
            System.out.println(0);
        }
        else System.out.println(max-1);
    }

    public static void BFS(){

        while(!q.isEmpty()){

            Tomato temp=q.poll();

            for(int i=0;i<6;i++){
                int nh=temp.h+dh[i];
                int nr=temp.r+dr[i];
                int nc=temp.c+dc[i];

                if(nh>=0 && nr>=0 && nc>=0 && nh<H && nr<N && nc<M){
                    if(arr[nh][nr][nc]==0){
                        q.add(new Tomato(nh,nr,nc));
                        arr[nh][nr][nc]=arr[temp.h][temp.r][temp.c]+1;
                    }
                }
            }
        }
    }

    public static class Tomato{

        int h;
        int r;
        int c;

        public Tomato(int h, int r, int c){
            this.h=h;
            this.r=r;
            this.c=c;
        }
    }
}