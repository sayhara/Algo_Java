package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s[]=br.readLine().split("");
        int sum=0; // 각 자리수의 합
        boolean check=false; // 0 포함 여부 체크
        for(int i=0;i<s.length;i++){
            if(s[i].equals("0")) check=true;
            else sum+=Integer.parseInt(s[i]);
        }
        if(!check || sum%3!=0){
            System.out.println(-1);
            return;
        }
        Arrays.sort(s, Comparator.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String st:s) sb.append(st);
        System.out.println(sb.toString());

    }
}
