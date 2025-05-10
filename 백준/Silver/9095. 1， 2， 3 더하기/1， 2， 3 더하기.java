import java.io.*;
import java.util.*;

public class Main {

    static int dp[];

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){
            int num=Integer.parseInt(br.readLine());
            dp=new int[num+1];
            check(num);
            sb.append(dp[num]+"\n");
        }
        System.out.println(sb);
    }

    public static void check(int num){

        for(int i=1;i<=num;i++){
            if(i==1) dp[i]=1;
            else if(i==2) dp[i]=2;
            else if(i==3) dp[i]=4;
            else {
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
    }
}