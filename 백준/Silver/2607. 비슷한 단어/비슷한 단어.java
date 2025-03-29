import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        String start=br.readLine();
        int result=0;

        for(int i=0;i<N-1;i++){
            String tmp=br.readLine();
            int alpha[]=new int[26];
            int count=0;
            for(int j=0;j<start.length();j++){
                alpha[start.charAt(j)-'A']++;
            }

            for(int j=0;j<tmp.length();j++){
                if(alpha[tmp.charAt(j)-'A']>0){
                    count++;
                    alpha[tmp.charAt(j)-'A']--;
                }
            }

            // 문자열 같거나, 한글자만 바뀐 경우
            if(start.length()==tmp.length() &&
                    (start.length()==count || start.length()-1==count)){
                result++;
            }

            // 한글자가 더 작은 경우
            else if(start.length()==tmp.length()-1 &&
                        tmp.length()-1==count){
                result++;
            }

            // 한글자가 더 긴 경우
            else if(start.length()==tmp.length()+1 &&
                        tmp.length()==count){
                result++;
            }

        }

        System.out.println(result);

    }
}