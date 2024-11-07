package BAEKJOON.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11497 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        while(T-->0){
            int N=Integer.parseInt(br.readLine());
            int arr[]=new int[N];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0;i<arr.length;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int tree[]=new int[N];
            for(int i=0;i<tree.length/2;i++){
                tree[i]=arr[i*2];
                tree[N-i-1]=arr[i*2+1];
            }

            if(N%2==1){
                tree[N/2]=arr[N-1];
            }

            int max=Math.abs(tree[0]-tree[N-1]);
            int diff=0;
            for(int i=0;i<N-1;i++){
                diff=Math.abs(tree[i]-tree[i+1]);
                if(diff>max) max=diff;
            }
            System.out.println(max);

        }
    }
}
