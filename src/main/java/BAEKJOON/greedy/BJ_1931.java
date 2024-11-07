package BAEKJOON.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[][]=new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            arr[i][0]=start;
            arr[i][1]=end;
        }

        Arrays.sort(arr,new Comparator<int[]>(){

            public int compare(int n1[], int n2[]){
                if(n1[1]>n2[1]){
                    return 1; // 종료시간 기준 오름차순
                }
                else if(n1[1]==n2[1]){
                    if(n1[0]>n2[0]){
                        return 1;
                    }
                }
                return -1;
            }
        });

        int end=arr[0][1];
        int cnt=1;

        for(int i=1;i<N;i++){
            if(arr[i][0]>=end){
                end=arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
