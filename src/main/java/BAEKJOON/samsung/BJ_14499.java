package BAEKJOON.samsung;
import java.io.*;
import java.util.*;

public class BJ_14499 {

    static int N,M,x,y,K;
    static int arr[][];
    static int dice[];
    static int dr[]={0,0,-1,1};
    static int dc[]={1,-1,0,0}; // 동서남북

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 세로
        M=Integer.parseInt(st.nextToken()); // 가로
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        dice=new int[7];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int d=Integer.parseInt(st.nextToken());
            roll(x,y,d);
        }
    }

    public static void roll(int r, int c ,int d){

        int nr=r+dr[d-1];
        int nc=c+dc[d-1];

        if(nr<0 || nc<0 || nr>=N || nc>=M)  return;

        int tmp=dice[6]; // 밑면

        switch(d){ // 동서남북
            case 1:
                dice[6]=dice[3];
                dice[3]=dice[1];
                dice[1]=dice[4];
                dice[4]=tmp;
                break;
            case 2:
                dice[6]=dice[4];
                dice[4]=dice[1];
                dice[1]=dice[3];
                dice[3]=tmp;
                break;
            case 3:
                dice[6]=dice[5];
                dice[5]=dice[1];
                dice[1]=dice[2];
                dice[2]=tmp;
                break;
            case 4:
                dice[6]=dice[2];
                dice[2]=dice[1];
                dice[1]=dice[5];
                dice[5]=tmp;
                break;
        }

        x=nr;
        y=nc;

        if(arr[nr][nc]==0){
            arr[nr][nc]=dice[6];
        } else {
            dice[6]=arr[nr][nc];
            arr[nr][nc]=0;
        }
        System.out.println(dice[1]);
    }
}
