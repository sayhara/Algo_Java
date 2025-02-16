import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        String A=st.nextToken();
        String B=st.nextToken();
        int max=0;

        for(int diff=0;diff<=B.length()-A.length();diff++){
            int count=0;
            for(int i=diff;i<diff+A.length();i++){
                if(B.charAt(i)==A.charAt(i-diff)) count++;
            }
            max=Math.max(max,count);
        }
        System.out.println(A.length()-max);

    }

}