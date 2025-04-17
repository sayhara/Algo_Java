import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 수의 개수
        int M=Integer.parseInt(st.nextToken()); // 합의 횟수
        int arr[]=new int[N];
        int sum[]=new int[N+1];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<=N;i++){
            sum[i]=arr[i-1]+sum[i-1];
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken())-1;
            int end=Integer.parseInt(st.nextToken());
            System.out.println(sum[end]-sum[start]);
        }
    }
}