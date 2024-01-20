package search;
import java.io.*;
import java.util.*;

public class BJ_15650 {

    static int N,M;
    static int arr[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }

        combination(0,0);

    }

    public static void combination(int start, int depth){

        if(depth==M){
            for(int i=0;i<N;i++){
                if(visited[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=start;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                combination(i+1,depth+1);
                visited[i]=false;
            }
        }
    }
}
