package BAEKJOON.greedy;

import java.io.*;
import java.util.*;

public class BJ_1080 {

    static int N,M;
    static int before[][];
    static int after[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        before=new int[N][M];
        after=new int[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                before[i][j]=s.charAt(j)-'0';
            }
        }
        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                after[i][j]=s.charAt(j)-'0';
            }
        }

        if(N<3 || M<3){
            if(check()){
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }

        int count=0;
        for(int i=0;i<N-2;i++){
            for(int j=0;j<M-2;j++){
                if(before[i][j]!=after[i][j]){
                    change(i,j);
                    count++;
                }
            }
        }

        if(!check()){
            System.out.println(-1);
            return;
        }
        System.out.println(count);

    }

    public static boolean check(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(before[i][j]!=after[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void change(int r, int c){

        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(before[i][j]==0) before[i][j]=1;
                else if(before[i][j]==1) before[i][j]=0;
            }
        }
    }
}
