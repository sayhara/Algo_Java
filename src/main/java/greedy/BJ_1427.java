package greedy;

import java.io.*;
import java.util.*;

public class BJ_1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        String arr[]=new String[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i)+"";
        }
        Arrays.sort(arr,Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"");
        }
    }
}
