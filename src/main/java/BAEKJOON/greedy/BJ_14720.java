package BAEKJOON.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int count=0;
        int idx=0;
        int num=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                idx=i;
                num++;
                count++;
                break;
            }
        }

        for(int i=idx;i<arr.length;i++){
            if(num==3) num=0;
            if(arr[i]==num){
                num++;
                count++;
            }
        }
        System.out.println(count);
    }
}
