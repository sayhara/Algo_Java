package search;
import java.io.*;
import java.util.*;

public class BJ_15654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int arr[]=new int[N];
        boolean visited[]=new boolean[N];
        int result[]=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(arr,visited,result,0,M);

    }

    public static void permutation(int arr[], boolean visited[], int result[], int depth, int r){

        if(depth==r){
            for(int i=0;i<r;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                result[depth]=arr[i];
                permutation(arr,visited,result,depth+1,r);
                visited[i]=false;
            }
        }
    }
}
