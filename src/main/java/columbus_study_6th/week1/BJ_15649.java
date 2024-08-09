package columbus_study_6th.week1;
import java.io.*;
import java.util.*;

public class BJ_15649 {

    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int arr[]=new int[N];
        int output[]=new int[N];
        boolean visited[]=new boolean[N];

        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }

        permutation(arr,output,visited,0,M);

    }

    public static void permutation(int arr[], int output[], boolean visited[], int depth, int r){

        if(depth==r){
            for(int i=0;i<r;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(arr,output,visited,depth+1,r);
                visited[i]=false;
            }
        }
    }
}
