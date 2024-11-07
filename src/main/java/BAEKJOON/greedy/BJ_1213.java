package BAEKJOON.greedy;

import java.io.*;

public class BJ_1213 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        // 알파벳의 홀수의 개수가 0개 또는 1개
        int alpha[]=new int[26];
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-65]++;
        }

        int count=0;
        String center="";
        for(int i=0;i<26;i++){
            if(alpha[i]%2==1){
                center=(char)(i+65)+"";
                alpha[i]--;
                count++;
            }
        }
        if(count>1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            if(alpha[i]%2==0 && alpha[i]!=0){
                for(int j=0;j<alpha[i]/2;j++){
                    char ch=(char)(i+65);
                    sb.append(ch+"");
                }
            }
        }
        System.out.println(sb.toString()+center+sb.reverse());
    }
}
