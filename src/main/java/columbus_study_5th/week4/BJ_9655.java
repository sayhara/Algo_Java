package columbus_study_5th.week4;
import java.io.*;

public class BJ_9655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        int turn=0;
        while(N!=0){
            turn++;
            if(N>3) N-=3;
            else N-=1;
        }

        if(turn%2==1){
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

        // DP를 이용한 방법

        int dp[]=new int[1001];
        dp[1]=1;
        dp[2]=2;
        dp[3]=1;
        for(int i=4;i<=N;i++){
            dp[i]=Math.min(dp[i-1],dp[i-3])+1;
        }

        if(dp[N]%2==0){
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }
}
