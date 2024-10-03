package search;

import java.io.*;
import java.util.*;

public class BJ_2512 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        int left=0, right=-1;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            right=Math.max(right,arr[i]);
        }
        int amt=Integer.parseInt(br.readLine());

        while(left<=right){
            int mid=(left+right)/2;
            long budget=0;
            for(int i=0;i<N;i++){
                if(arr[i]>mid) budget+=mid;
                else budget+=arr[i];
            }

            // 예산 도달 못한 경우
            if(budget<=amt){
                left=mid+1;
            } else { // 예산을 초과한 경우 경우
                right=mid-1;
            }
        }
        System.out.println(right);
    }
}
