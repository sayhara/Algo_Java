package BAEKJOON.samsung;
import java.io.*;
import java.util.*;

public class BJ_14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int T[]=new int[N];
        int P[]=new int[N];
        int DP[]=new int[N+1];  // 누적되는 다음날의 금액

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            if(i+T[i]<=N){
                DP[i+T[i]]=Math.max(DP[i+T[i]],DP[i]+P[i]);
            }
            DP[i+1]=Math.max(DP[i+1],DP[i]);
        }

        System.out.println(DP[N]);
    }
}
