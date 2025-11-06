import java.io.*;
import java.util.*;

// 그룹 단어 체커
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int sum=N;

        for(int i=0;i<N;i++){
            String s=br.readLine();
            boolean alpha[]=new boolean[26];
            alpha[s.charAt(0)-'a']=true;
            for(int j=1;j<s.length();j++){
                if(s.charAt(j)==s.charAt(j-1)) continue;
                else {
                    if(!alpha[s.charAt(j)-'a']){
                        alpha[s.charAt(j)-'a']=true;
                    }
                    else {
                        sum--;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
