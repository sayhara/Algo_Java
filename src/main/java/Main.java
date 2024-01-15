import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        String s=br.readLine();
        String result="";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='S') result+="*S";
            else {
                result+="*LL";
                i++;
            }
        }
        result+="*";

        int cnt=0;
        for(int i=0;i<result.length();i++){
            if(result.charAt(i)=='*') cnt++;
        }

        System.out.println(Math.min(cnt,N));

    }
}