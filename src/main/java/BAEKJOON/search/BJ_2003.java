package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_2003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int arr[]=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int start=0, end=0, sum=0, count=0;
        while(true){
            if(sum>=M){
                sum-=arr[start];
                start++;
            }
            else if(end==N){
                break;
            }
            else {
                sum+=arr[end];
                end++;
            }
            if(sum==M) count++;
        }
        System.out.println(count);
    }

}