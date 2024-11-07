package BAEKJOON.greedy;

import java.io.*;

public class BJ_1065 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        if(N<100){
            System.out.println(N);
            return;
        }

        int sum=99;
        for(int i=100;i<=N;i++){
            if(check(i)) sum++;
        }
        System.out.println(sum);
    }

    public static boolean check(int n){

        String s=Integer.toString(n);
        int n1=s.charAt(0)-'0';
        int n2=s.charAt(1)-'0';
        int diff=n2-n1;

        for(int i=1;i<s.length()-1;i++){
            int s1=s.charAt(i)-'0';
            int s2=s.charAt(i+1)-'0';
            if(diff!=s2-s1){
                return false;
            }
        }
        return true;
    }
}
