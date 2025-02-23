import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int A[]=new int[N];
        int B[]=new int[M];
        StringBuilder sb=new StringBuilder();

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            B[i]=Integer.parseInt(st.nextToken());
        }

        int idx1=0; int idx2=0;
        while(idx1<N && idx2<M){
            if(A[idx1]<=B[idx2]){
                sb.append(A[idx1++]+" ");
            } else {
                sb.append(B[idx2++]+" ");
            }
        }

        if(idx1==N){
            for(int i=idx2;i<M;i++){
                sb.append(B[i]+" ");
            }
        }

        if(idx2==M){
            for(int i=idx1;i<N;i++){
                sb.append(A[i]+" ");
            }
        }
        System.out.println(sb);
    }
}