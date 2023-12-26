package greedy;

import java.io.*;
import java.util.*;

public class BJ_1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        String sp[]=s.split("-");

        String start[]=sp[0].split("\\+");
        long sum=0;
        for(int i=0;i<start.length;i++){
            sum+=Integer.parseInt(start[i]);
        }

        for(int i=1;i<sp.length;i++){
            String str[]=sp[i].split("\\+");
            long value=0;
            for(int j=0;j<str.length;j++){
                value+=Integer.parseInt(str[j]);
            }
            sum-=value;
        }
        System.out.println(sum);

    }
}
