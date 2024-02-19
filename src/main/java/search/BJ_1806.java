package search;
import java.io.*;
import java.util.*;

public class BJ_1806 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int arr[]=new int[N+1];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int start=0, end=0;
        long sum=0, answer=Long.MAX_VALUE;

        while(start<=N && end<=N){
            if(sum>=S){
                answer=Math.min(answer,end-start);
                sum-=arr[start];
                start++;
            } else {
                sum+=arr[end];
                end++;
            }
        }
        if(answer==Long.MAX_VALUE){
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
