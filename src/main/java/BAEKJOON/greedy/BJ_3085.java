package BAEKJOON.greedy;

import java.io.*;

public class BJ_3085 {

    static int N;
    static char arr[][];
    static int max=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new char[N][N];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j);
            }
        }

        // 열끼리 비교
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                swap(i,j,i,j+1);
                search();
                swap(i,j+1,i,j);

            }
        }

        // 행끼리 비교
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N;j++){
                swap(i,j,i+1,j);
                search();
                swap(i+1,j,i,j);
            }
        }
        System.out.println(max);

    }

    public static void swap(int r1, int c1, int r2, int c2){
        char tmp=arr[r1][c1];
        arr[r1][c1]=arr[r2][c2];
        arr[r2][c2]=tmp;
    }

    public static void search(){

        for(int i=0;i<N;i++){
            int cnt=1;
            for(int j=0;j<N-1;j++){
                if(arr[i][j]==arr[i][j+1]){
                    cnt++;
                    max=Math.max(max,cnt);
                } else {
                    cnt=1;
                }
            }
        }

        for(int i=0;i<N;i++){
            int cnt=1;
            for(int j=0;j<N-1;j++){
                if(arr[j][i]==arr[j+1][i]){
                    cnt++;
                    max=Math.max(max,cnt);
                } else {
                    cnt=1;
                }
            }
        }
    }

}
