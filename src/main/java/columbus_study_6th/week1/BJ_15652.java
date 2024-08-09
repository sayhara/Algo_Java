package columbus_study_6th.week1;
import java.io.*;
import java.util.*;

public class BJ_15652 {

    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int arr[]=new int[N];
        int output[]=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }

        combination(arr,output,0,0,M);

    }

    public static void combination(int arr[], int output[], int start, int depth, int r){

        if(depth==r){
            for(int i=0;i<r;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start;i<N;i++){
            output[depth]=arr[i];
            combination(arr,output,i,depth+1,r);
        }
    }

}
