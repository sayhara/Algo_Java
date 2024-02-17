package search;
import java.io.*;
import java.util.*;

public class BJ_1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int K=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        long line[]= new long[K];
        long left=1, right=Integer.MIN_VALUE;
        long mid;

        for(int i=0;i<K;i++){
            line[i]=Integer.parseInt(br.readLine());
            right=Math.max(right,line[i]);
        }

        while(left<=right){ // 자를 수 있는 길이
            mid=(left+right)/2;
            long sum=0;
            for(int i=0;i<K;i++){
                sum+=line[i]/mid;
            }
            if(sum>=N){
                left=mid+1;
            } else if(sum<N){
                right=mid-1;
            }
        }
        System.out.println(right);
    }
}
