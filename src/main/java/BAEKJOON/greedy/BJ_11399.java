package BAEKJOON.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N]; // 배열 대기시간
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum=arr[0];
        for(int i=1;i<N;i++){
            sum+=arr[i];
            arr[i]=sum;
        }

        int result=0;
        for(int i=0;i<N;i++){
            result+=arr[i];
        }
        System.out.println(result);

    }
}
