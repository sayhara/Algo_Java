package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_10819 {

    static int N;
    static int arr[];
    static int output[];
    static boolean visited[];
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        output=new int[N];
        visited=new boolean[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        permutation(0);
        System.out.println(max);

    }

    public static void permutation(int depth){

        if(depth==N){
            check();
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(depth+1);
                visited[i]=false;
            }
        }
    }

    public static void check(){
        int sum=0;

        for(int i=0;i<N-1;i++){
            sum+=Math.abs(output[i]-output[i+1]);
        }

        max=Math.max(sum,max);
    }
}
