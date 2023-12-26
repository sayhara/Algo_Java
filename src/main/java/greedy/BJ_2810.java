package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2810 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String result="";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='S'){
                result+="*S";
            }
            else {
                result+="*LL";
                i++;
            }
        }
        result+="*";
        int count=0;
        for(int i=0;i<result.length();i++){
            if(result.charAt(i)=='*') count++;
        }
        System.out.println(Math.min(count,N));
    }
}
