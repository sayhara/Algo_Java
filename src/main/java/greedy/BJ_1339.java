package greedy;

import java.io.*;
import java.util.*;

public class BJ_1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int alpha[]=new int[26];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                int idx=s.charAt(j)-65;
                alpha[idx]+=(int)(Math.pow(10,s.length()-1-j));
            }
        }
        Arrays.sort(alpha);

        int sum=0;
        int value=9;

        for(int i=alpha.length-1;i>=0;i--){
            sum+=alpha[i]*value;
            value--;
        }
        System.out.println(sum);

    }
}
