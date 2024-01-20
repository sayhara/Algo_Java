package search;
import java.io.*;
import java.util.*;

public class BJ_15649 {

    static int N,M;
    static int arr[];
    static int result[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        result=new int[N];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }

        permutation(0);

    }

    public static void permutation(int depth){

        if(depth==M){
            for(int i=0;i<M;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                result[depth]=arr[i];
                permutation(depth+1);
                visited[i]=false;
            }
        }
    }
}
