package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_10971 {

    static int N;
    static int arr[][];
    static boolean visited[];
    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            visited[i]=true;
            solve(i,i,0,0);
        }
        System.out.println(result);

    }

    public static void solve(int start, int now, int depth, int sum){

        if(depth==N-1){
            if(arr[now][start]!=0){
                sum+=arr[now][start];
                result=Math.min(sum,result);
            }
        }

        for(int i=0;i<N;i++){
            if(!visited[i] && arr[now][i]>0){
                visited[i]=true;
                solve(start,i,depth+1,sum+arr[now][i]);
                visited[i]=false;
            }
        }
    }
}
