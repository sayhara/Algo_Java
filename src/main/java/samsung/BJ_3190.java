package samsung;
import java.io.*;
import java.util.*;

public class BJ_3190 {

    static Deque<Snake> snake=new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int K=Integer.parseInt(br.readLine());
        int arr[][]=new int[N][N];

        StringTokenizer st;
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr[r][c]=9; // 사과의 위치
        }

        int L=Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            st=new StringTokenizer(br.readLine());
            int X=Integer.parseInt(st.nextToken());
            String C=st.nextToken();
            snake.add(new Snake(X,C));  // 방향 변환정보
        }

        int time=0;


    }

    public static class Snake {

        int time;
        String dir;

        public Snake(int time, String dir){
            this.time=time;
            this.dir=dir;
        }

    }


}
