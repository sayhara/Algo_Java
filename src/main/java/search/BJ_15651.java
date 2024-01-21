package search;
import java.io.*;
import java.util.*;

public class BJ_15651 {

    static int N,M;
    static int arr[];
    static int output[];
    static StringBuilder sb=new StringBuilder();
    // 중복 순열

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        output=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }

        permutation(0);
        System.out.println(sb.toString());

    }

    public static void permutation(int depth){

        if(depth==M){
            for(int i=0;i<M;i++){
                sb.append(output[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            output[depth]=arr[i];
            permutation(depth+1);
        }

    }
}
