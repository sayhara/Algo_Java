package search;
import java.io.*;
import java.util.*;

public class BJ_14503 {

    static int N,M;
    static int arr[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1}; // 북동남서
    static int count=1;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];

        st=new StringTokenizer(br.readLine());
        int r=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        clean(r,c,d);
        System.out.println(count);
    }

    public static void clean(int r, int c, int d){

        arr[r][c]=9;

        for(int i=0;i<4;i++){
            d=(d+3)%4; // 반시계
            int nr=r+dr[d];
            int nc=c+dc[d];

            if(nr>=0 && nc>=0 && nr<N && nc<M){
                if(arr[nr][nc]==0){
                    count++;
                    clean(nr,nc,d);
                    return;
                }
            }
        }

        int nd=(d+2)%4;
        int nr=r+dr[nd];
        int nc=c+dc[nd];

        if(nr>=0 && nc>=0 && nr<N && nc<M && arr[nr][nc]!=1){
            clean(nr,nc,d);
        }
    }
}
