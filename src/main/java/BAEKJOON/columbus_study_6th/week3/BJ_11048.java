package BAEKJOON.columbus_study_6th.week3;
import java.io.*;
import java.util.*;

public class BJ_11048 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int maze[][]=new int[N+1][M+1];
        int dp[][]=new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                maze[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                dp[i][j]=Math.max(maze[i][j]+dp[i][j-1],maze[i][j]+dp[i-1][j]);
            }
        }

        System.out.println(dp[N][M]);

    }
}
