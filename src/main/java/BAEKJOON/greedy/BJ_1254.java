package BAEKJOON.greedy;
import java.io.*;

public class BJ_1254 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        int ans=s.length();

        for(int i=0;i<s.length();i++){
            if(isPalindrome(s.substring(i))){
                break;
            }
            ans++;
        }

        System.out.println(ans);
    }

    public static boolean isPalindrome(String s){

        int start=0;
        int end=s.length()-1;

        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
