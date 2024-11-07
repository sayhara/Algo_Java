package BAEKJOON.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10162 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        int A=0,B=0,C=0;

        while(T>0){

            if(T>=300){
                A=T/300;
                T=T%300;
            }

            if(T>=60){
                B=T/60;
                T=T%60;
            }

            if(T>=10){
                C=T/10;
                T=T%10;
            }

            if(T!=0){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(A+" "+B+" "+C);

    }
}
