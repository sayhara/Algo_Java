package BAEKJOON.greedy;

import java.io.*;

public class BJ_4375 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input;

        while((input=br.readLine())!=null){

            int N=Integer.parseInt(input);
            int value=0;

            for(int i=1;;i++){
                value=(value*10+1)%N;
                if(value==0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
