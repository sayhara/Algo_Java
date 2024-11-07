package BAEKJOON.greedy;
import java.io.*;

public class BJ_12904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String S=br.readLine();
        String T=br.readLine();

        while(T.length()>0){

            if(T.equals(S)){
                System.out.println(1);
                return;
            }

            char last=T.charAt(T.length()-1);
            T=T.substring(0,T.length()-1);
            if(last=='B'){
                StringBuilder sb=new StringBuilder();
                sb.append(T);
                T=sb.reverse().toString();
            }
        }
        System.out.println(0);
    }
}
