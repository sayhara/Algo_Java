package search;
import java.io.*;
import java.util.*;

public class BJ_1182 {

    static int N,S;
    static int arr[];
    static boolean visited[];
    static int cnt=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        arr=new int[N];
        visited=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++) {
            combination(0, 0,i);
        }

        System.out.println(cnt);

    }

    public static void combination(int start, int depth, int r){

        if(depth==r){
            check();
            return;
        }

        for(int i=start;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                combination(i+1,depth+1,r);
                visited[i]=false;
            }
        }
    }

    public static void check(){

        int sum=0;

        for(int i=0;i<N;i++){
            if(visited[i]){
                sum+=arr[i];
            }
        }

        if(sum==S) cnt++;

    }
}
