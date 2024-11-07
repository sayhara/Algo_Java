package BAEKJOON.greedy;

import java.io.*;

public class BJ_1439 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        int zeroCount=0, oneCount=0;

        if(s.startsWith("0")) zeroCount++;
        else if(s.startsWith("1")) oneCount++;

        if(s.length()<2){
            System.out.println(Math.min(zeroCount,oneCount));
            return;
        }

        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                if(s.charAt(i)=='0'){
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }

        System.out.println(Math.min(zeroCount,oneCount));

    }

}
