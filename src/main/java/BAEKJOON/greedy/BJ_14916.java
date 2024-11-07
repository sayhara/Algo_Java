package BAEKJOON.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14916 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int num=n/5;
        int remain=n%5;

        for(int i=num;i>=0;i--){
            if(remain%2==0){
                int answer=i+remain/2;
                System.out.println(answer);
                return;
            }
            remain+=5;
        }
        System.out.println(-1);

    }
}
