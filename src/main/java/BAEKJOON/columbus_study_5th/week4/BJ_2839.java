package BAEKJOON.columbus_study_5th.week4;
import java.io.*;
import java.util.*;

public class BJ_2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int dp[]=new int[5001];
        if(N==4){
            System.out.println(-1);
            return;
        }
        Arrays.fill(dp,9999);
        dp[3]=1;
        dp[5]=1;
        for(int i=6;i<dp.length;i++){
            dp[i]=Math.min(dp[i-3]+1,dp[i-5]+1);
        }

        if(dp[N]>9999){
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }

    }
}
