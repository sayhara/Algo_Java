package BAEKJOON.greedy;

import java.io.*;
import java.util.*;

public class BJ_1051 {



    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int arr[][]=new int[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        int len=Math.min(N,M);

        for(int val=len-1;val>=0;val--){
            for(int i=0;i<N-val;i++){
                for(int j=0;j<M-val;j++){
                    if(arr[i][j]==arr[i+val][j] && arr[i+val][j]==arr[i][j+val]
                            && arr[i][j+val]==arr[i+val][j+val]){
                        val++;
                        System.out.println(val*val);
                        return;
                    }
                }
            }
        }
    }
}
