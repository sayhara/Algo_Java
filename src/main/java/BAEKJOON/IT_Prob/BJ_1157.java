package BAEKJOON.IT_Prob;
import java.io.*;

public class BJ_1157 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine().toUpperCase();
        char ch[]=new char[26];
        int max=0;


        for(int i=0;i<s.length();i++){
            ch[s.charAt(i)-65]++;
        }

        for(int i=0;i<ch.length;i++){
            max=Math.max(max,ch[i]);
        }

        String result="";
        int cnt=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]==max){
                cnt++;
                result=(char)(i+65)+"";
            }
            if(cnt>1){
                System.out.println("?");
                return;
            }
        }
        System.out.println(result);
    }
}
